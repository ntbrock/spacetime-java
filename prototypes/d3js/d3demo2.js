/**
 * 2024-10-11 Brockman - Sample Spacetime Diagram from the reference material
 */

// Axes Tutorials: https://ghenshaw-work.medium.com/customizing-axes-in-d3-js-99d58863738b

// Viewport - Declare the chart dimensions and margins. - Simplified to 1000
const width = 1000;
const height = 1000;
const marginTop = 10;
const marginRight = 10;
const marginBottom = 10;
const marginLeft = 10;

// Coordinates
const minX = -10;
const maxX = 10;
const minT = -10;
const maxT = 10;

// Translation of coordinate systems = scaleLinear.domain and .range
// Declare the x (horizontal position) scale.
const xScale = d3.scaleLinear()
    .domain([minX, maxX])  // Physics Coordinate system
    .range([marginLeft, width - marginRight]) // Viewport Coordinate system.

// Declare the y (vertical position) scale.
const tScale = d3.scaleLinear()
    .domain([minT, maxT])
    .range([height - marginBottom, marginTop]);

// Create the SVG container.
const svg = d3.create("svg")
    .attr("width", width)
    .attr("height", height);

// Add the x-axis.
svg.append("g")
    .attr("transform", `translate(0,${((height)/2)})`)
    .call(d3.axisBottom(xScale));

// Add the y-axis.
svg.append("g")
    .attr("transform", `translate(${(width)/2},0)`)
    .call(d3.axisLeft(tScale));


// Draw a light line

// Draw a Light like line ct
svg.append("line")
    .style("stroke", "gray")
    .attr("x1", xScale(minX))
    .attr("x2", xScale(maxX))
    .attr("y1", tScale(minT))
    .attr("y2", tScale(maxT));

// Draw a Light like line -ct
svg.append("line")
    .style("stroke", "gray")
    .attr("x1", xScale(maxX))
    .attr("x2", xScale(minX))
    .attr("y1", tScale(minT))
    .attr("y2", tScale(maxT));

// Your World Line (Vertical)
svg.append("line")
    .style("stroke", "red")
    .style("stroke-width", "3")
    .attr("x1", xScale(0))
    .attr("x2", xScale(0))
    .attr("y1", tScale(minT))
    .attr("y2", tScale(maxT));

// Other Reference Frame World Line (Vertical)
svg.append("line")
    .style("stroke", "blue")
    .style("stroke-width", "3")
    .attr("x1", xScale(-5))
    .attr("x2", xScale(5))
    .attr("y1", tScale(minT))
    .attr("y2", tScale(maxT));

// SVG: <line x1="255" x2="745" y1="990" y2="10" style="stroke: blue; stroke-width: 3;"></line>

// Append the SVG element.
container.append(svg.node());
