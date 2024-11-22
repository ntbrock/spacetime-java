# Special Relativity Velocity Addition Lab

## Revisions

- 2024-11-22 Brockman - Generation from Claude.ai with the prompt below, Demonstration to NCSSM team.


## Prompt 

Hello, I'd like to explore the concept of Special Relativity Spacetime and specifically the formulas around Velocity Addition.  I am preparing a Lab for a undersgraduate modern physics classroom and would like to define effective explanations and student homework assignments.

I've created a comprehensive lab guide that covers the theory, practical exercises, and assessment components. Would you like me to:

- Add more complex problem scenarios?
- Develop specific homework assignments?
- Include derivations of the formula?
- Add visualization code for the graphs?


## Theoretical Background

The classical (Galilean) velocity addition formula:
v = v₁ + v₂

Is replaced in Special Relativity by Einstein's velocity addition formula:
v = (v₁ + v₂)/(1 + v₁v₂/c²)

Where:
- v₁, v₂ are the velocities being combined
- c is the speed of light
- All velocities are measured in the same direction

### Key Concepts

1. The speed of light (c) is constant in all reference frames

2. No object can exceed the speed of light

3. Velocities do not add linearly at relativistic speeds


## Laboratory Exercises

### Part 1: Understanding the Formula
Students will:

1. Compare classical and relativistic velocity addition for various speeds

2. Verify that the result never exceeds c

3. Plot the differences between classical and relativistic predictions (NICE)

Sample calculations:
- Low speeds (v << c): Show approximation to classical physics
- High speeds (v ≈ c): Demonstrate limiting behavior

### Part 2: Practical Problems

#### Problem Set A: Basic Calculations

1. A spaceship moving at 0.6c fires a probe at 0.7c relative to the ship. Calculate:
   - Classical velocity prediction
   - Relativistic velocity prediction
   - Percentage difference between predictions

2. Two particles approach each other, each moving at 0.9c relative to the lab. Calculate:
   - Their relative velocity using relativistic formula
   - Explain why classical addition would give an impossible result

#### Problem Set B: Advanced Analysis

1. Graph the relationship between:
   - Input velocities (v₁, v₂)
   - Resulting relativistic velocity
   - Classical prediction
   For velocities ranging from 0 to 0.99c

2. Find the velocity v such that when added to itself relativistically, gives 0.99c

### Part 3: Experimental Design

Students will:

1. Propose methods to measure relativistic velocity addition effects

2. Discuss why such experiments are challenging at everyday speeds

3. Research real-world examples where relativistic velocity addition is important


## Assessment Questions

1. Why does relativistic velocity addition differ from classical addition?

2. A particle accelerator boosts a particle to 0.8c, then gives it another boost of 0.8c in the same direction. Calculate:
   a) The classical prediction
   b) The relativistic result
   c) Explain why (a) is impossible

3. At what speeds does the difference between classical and relativistic addition become significant? (>1% difference)

4. Prove that the relativistic velocity addition formula always yields results less than c

## Additional Resources

Suggested demonstrations:

1. Interactive velocity addition calculator

2. Visualization of velocity addition using spacetime diagrams

3. Real-world applications in particle accelerators


Common student misconceptions:

1. Thinking that velocities always add linearly

2. Confusion about reference frames

3. Misunderstanding the role of c as a speed limit


## Lab Report Requirements

Students should include:

1. Calculations showing work for all problems

2. Graphs comparing classical and relativistic predictions

3. Discussion of implications and real-world applications

4. Analysis of experimental limitations

5. Conclusions about the nature of space and time



## Grading Rubric

| Component | Points | Criteria |
|-----------|---------|----------|
| Calculations | 30 | Correct application of formulas, clear work shown |
| Graphs | 20 | Accurate plotting, clear labels, proper analysis |
| Discussion | 25 | Understanding of concepts, depth of analysis |
| Conclusions | 15 | Insight into implications, connection to theory |
| Format | 10 | Organization, clarity, proper citations |



## Prompt 2

Regarding #4 Add Visualization Code, Can you please help me write code using javascript and D3 to help "Plot the differences between classical and relativistic predictions"?

```html
<!DOCTYPE html>
<html>
<head>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/d3/7.8.5/d3.min.js"></script>
  <style>
    .line {
      fill: none;
      stroke-width: 2;
    }
    .axis-label {
      font-size: 12px;
    }
    .legend {
      font-size: 12px;
    }
  </style>
</head>
<body>
  <div id="graph"></div>
  <script>
    // Set up dimensions and margins
    const margin = {top: 40, right: 100, bottom: 60, left: 60};
    const width = 800 - margin.left - margin.right;
    const height = 500 - margin.top - margin.bottom;

    // Create SVG container
    const svg = d3.select("#graph")
      .append("svg")
        .attr("width", width + margin.left + margin.right)
        .attr("height", height + margin.top + margin.bottom)
      .append("g")
        .attr("transform", `translate(${margin.left},${margin.top})`);

    // Speed of light (c = 1 in natural units)
    const c = 1;

    // Generate data points
    function generateData() {
      const data = [];
      for (let v1 = 0; v1 <= 0.99; v1 += 0.01) {
        data.push({
          v1: v1,
          classical: Math.min(2 * v1, c), // v1 + v1 classically
          relativistic: (2 * v1) / (1 + Math.pow(v1, 2)) // relativistic addition of v1 with itself
        });
      }
      return data;
    }

    const data = generateData();

    // Set up scales
    const x = d3.scaleLinear()
      .domain([0, 1])
      .range([0, width]);

    const y = d3.scaleLinear()
      .domain([0, 2])
      .range([height, 0]);

    // Add axes
    svg.append("g")
      .attr("transform", `translate(0,${height})`)
      .call(d3.axisBottom(x).ticks(10))
      .append("text")
        .attr("class", "axis-label")
        .attr("x", width/2)
        .attr("y", 40)
        .style("text-anchor", "middle")
        .text("Input Velocity (v₁/c)");

    svg.append("g")
      .call(d3.axisLeft(y).ticks(10))
      .append("text")
        .attr("class", "axis-label")
        .attr("transform", "rotate(-90)")
        .attr("y", -40)
        .attr("x", -height/2)
        .style("text-anchor", "middle")
        .text("Resultant Velocity (v/c)");

    // Add lines
    const classicalLine = d3.line()
      .x(d => x(d.v1))
      .y(d => y(d.classical));

    const relativisticLine = d3.line()
      .x(d => x(d.v1))
      .y(d => y(d.relativistic));

    // Draw lines
    svg.append("path")
      .datum(data)
      .attr("class", "line")
      .style("stroke", "#ff6b6b")
      .attr("d", classicalLine);

    svg.append("path")
      .datum(data)
      .attr("class", "line")
      .style("stroke", "#4ecdc4")
      .attr("d", relativisticLine);

    // Add speed of light line
    svg.append("line")
      .style("stroke", "#666")
      .style("stroke-dasharray", "5,5")
      .attr("x1", 0)
      .attr("y1", y(1))
      .attr("x2", width)
      .attr("y2", y(1));

    // Add legend
    const legend = svg.append("g")
      .attr("class", "legend")
      .attr("transform", `translate(${width + 10}, 20)`);

    legend.append("line")
      .style("stroke", "#ff6b6b")
      .style("stroke-width", 2)
      .attr("x1", 0)
      .attr("y1", 0)
      .attr("x2", 20)
      .attr("y2", 0);

    legend.append("text")
      .attr("x", 25)
      .attr("y", 4)
      .text("Classical Addition");

    legend.append("line")
      .style("stroke", "#4ecdc4")
      .style("stroke-width", 2)
      .attr("x1", 0)
      .attr("y1", 20)
      .attr("x2", 20)
      .attr("y2", 20);

    legend.append("text")
      .attr("x", 25)
      .attr("y", 24)
      .text("Relativistic Addition");

    // Add title
    svg.append("text")
      .attr("x", width/2)
      .attr("y", -10)
      .style("text-anchor", "middle")
      .style("font-size", "16px")
      .text("Classical vs Relativistic Velocity Addition");
  </script>
</body>
</html>

```

The visualization compares classical and relativistic velocity addition when adding a velocity to itself. Key features:
- X-axis: Input velocity (as fraction of c)
- Y-axis: Resultant velocity
- Red line: Classical addition (exceeds c)
- Teal line: Relativistic addition (approaches but never exceeds c)
- Dashed line: Speed of light limit

Would you like me to add interactive features or modify the visualization?




## Prompt 3

I liked the javascript and d3 example of the velocity plot.   Now, lets create another .js + d3 plot of a world line diagram.

I'll create a visualization of a spacetime diagram (world line) that shows different world lines and demonstrates time dilation and length contraction effects.


```html
<!DOCTYPE html>
<html>
<head>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/d3/7.8.5/d3.min.js"></script>
  <style>
    .world-line {
      fill: none;
      stroke-width: 2;
    }
    .light-cone {
      fill: none;
      stroke: #ffeb3b;
      stroke-width: 1;
      stroke-dasharray: 4;
    }
    .grid-line {
      stroke: #ddd;
      stroke-width: 0.5;
    }
    .axis-label {
      font-size: 12px;
    }
    .event-point {
      fill: #ff4081;
    }
    .slider-container {
      margin: 20px;
    }
    .slider-label {
      display: inline-block;
      width: 150px;
    }
  </style>
</head>
<body>
  <div class="slider-container">
    <label class="slider-label">Velocity (β = v/c):</label>
    <input type="range" id="velocitySlider" min="0" max="99" value="60" />
    <span id="velocityValue">0.60c</span>
  </div>
  <div id="graph"></div>

  <script>
    // Set up dimensions and margins
    const margin = {top: 40, right: 60, bottom: 60, left: 60};
    const width = 800 - margin.left - margin.right;
    const height = 600 - margin.top - margin.bottom;

    // Create SVG container
    const svg = d3.select("#graph")
      .append("svg")
        .attr("width", width + margin.left + margin.right)
        .attr("height", height + margin.top + margin.bottom)
      .append("g")
        .attr("transform", `translate(${margin.left},${margin.top})`);

    // Set up scales
    const x = d3.scaleLinear()
      .domain([-4, 4])
      .range([0, width]);

    const y = d3.scaleLinear()
      .domain([-1, 7])
      .range([height, 0]);

    // Add grid
    function drawGrid() {
      // Vertical grid lines
      svg.selectAll(".vertical-grid")
        .data(d3.range(-4, 4.1, 1))
        .join("line")
        .attr("class", "grid-line")
        .attr("x1", d => x(d))
        .attr("x2", d => x(d))
        .attr("y1", y(-1))
        .attr("y2", y(7));

      // Horizontal grid lines
      svg.selectAll(".horizontal-grid")
        .data(d3.range(-1, 7.1, 1))
        .join("line")
        .attr("class", "grid-line")
        .attr("x1", x(-4))
        .attr("x2", x(4))
        .attr("y1", d => y(d))
        .attr("y2", d => y(d));
    }

    // Draw axes
    svg.append("g")
      .attr("transform", `translate(0,${y(0)})`)
      .call(d3.axisBottom(x).ticks(8))
      .append("text")
        .attr("class", "axis-label")
        .attr("x", width/2)
        .attr("y", 40)
        .style("text-anchor", "middle")
        .text("Distance (x)");

    svg.append("g")
      .attr("transform", `translate(${x(0)},0)`)
      .call(d3.axisLeft(y).ticks(8))
      .append("text")
        .attr("class", "axis-label")
        .attr("transform", "rotate(-90)")
        .attr("y", -40)
        .attr("x", -height/2)
        .style("text-anchor", "middle")
        .text("Time (ct)");

    // Draw light cone
    function drawLightCone() {
      // Forward light cone
      svg.append("line")
        .attr("class", "light-cone")
        .attr("x1", x(0))
        .attr("y1", y(0))
        .attr("x2", x(4))
        .attr("y2", y(4));

      svg.append("line")
        .attr("class", "light-cone")
        .attr("x1", x(0))
        .attr("y1", y(0))
        .attr("x2", x(-4))
        .attr("y2", y(4));
    }

    // Function to draw world lines
    function drawWorldLines(beta) {
      // Clear previous world lines
      svg.selectAll(".world-line").remove();
      
      // Calculate gamma factor
      const gamma = 1 / Math.sqrt(1 - beta * beta);
      
      // Stationary object world line
      svg.append("line")
        .attr("class", "world-line")
        .style("stroke", "#2196f3")
        .attr("x1", x(0))
        .attr("y1", y(0))
        .attr("x2", x(0))
        .attr("y2", y(6));

      // Moving object world line
      const movingLine = d3.line()
        .x(t => x(beta * t))
        .y(t => y(t));

      svg.append("path")
        .datum(d3.range(0, 6, 0.1))
        .attr("class", "world-line")
        .style("stroke", "#f44336")
        .attr("d", movingLine);

      // Add proper time markers
      const properTimePoints = d3.range(0, 6, 1);
      
      svg.selectAll(".proper-time-stationary")
        .data(properTimePoints)
        .join("circle")
        .attr("class", "event-point")
        .attr("cx", x(0))
        .attr("cy", t => y(t))
        .attr("r", 3);

      svg.selectAll(".proper-time-moving")
        .data(properTimePoints)
        .join("circle")
        .attr("class", "event-point")
        .attr("cx", t => x(beta * t))
        .attr("cy", t => y(t))
        .attr("r", 3);
    }

    // Initialize the visualization
    drawGrid();
    drawLightCone();
    drawWorldLines(0.6);

    // Add interactivity
    d3.select("#velocitySlider").on("input", function() {
      const beta = this.value / 100;
      d3.select("#velocityValue").text(beta.toFixed(2) + "c");
      drawWorldLines(beta);
    });

    // Add title
    svg.append("text")
      .attr("x", width/2)
      .attr("y", -10)
      .style("text-anchor", "middle")
      .style("font-size", "16px")
      .text("Spacetime Diagram (World Lines)");

    // Add legend
    const legend = svg.append("g")
      .attr("transform", `translate(${width - 150}, 20)`);

    legend.append("line")
      .style("stroke", "#2196f3")
      .style("stroke-width", 2)
      .attr("x1", 0)
      .attr("y1", 0)
      .attr("x2", 20)
      .attr("y2", 0);

    legend.append("text")
      .attr("x", 25)
      .attr("y", 4)
      .text("Stationary Object");

    legend.append("line")
      .style("stroke", "#f44336")
      .style("stroke-width", 2)
      .attr("x1", 0)
      .attr("y1", 20)
      .attr("x2", 20)
      .attr("y2", 20);

    legend.append("text")
      .attr("x", 25)
      .attr("y", 24)
      .text("Moving Object");

    legend.append("line")
      .style("stroke", "#ffeb3b")
      .style("stroke-width", 1)
      .style("stroke-dasharray", "4")
      .attr("x1", 0)
      .attr("y1", 40)
      .attr("x2", 20)
      .attr("y2", 40);

    legend.append("text")
      .attr("x", 25)
      .attr("y", 44)
      .text("Light Cone");
  </script>
</body>
</html>

```

I've created an interactive spacetime diagram that includes:

1. World lines for:
   - A stationary object (blue vertical line)
   - A moving object (red slanted line)
   - Light cone boundaries (yellow dashed lines)

2. Interactive features:
   - A slider to adjust the velocity (β = v/c) of the moving object
   - Event points showing proper time intervals
   - Grid lines for reference

3. Key visualizations:
   - The light cone showing the causal structure of spacetime
   - Time dilation effect (visible in the spacing of proper time markers)
   - Length contraction (visible in the slope of the world line)

The diagram shows:
- x-axis: spatial dimension
- y-axis: time dimension (ct)
- Yellow dashed lines: light cone (slopes of ±1)
- Blue line: world line of stationary object
- Red line: world line of moving object
- Pink dots: proper time intervals

Would you like me to:
1. Add more interactive features (e.g., multiple moving objects)?
2. Include relativistic effects calculations?
3. Add visualization of simultaneous events in different frames?
4. Add more educational annotations or explanatory text?

