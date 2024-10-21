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

// Declare the x (horizontal position) scale.
const x = d3.scaleLinear()
    .domain([minX, maxX])
    .range([marginLeft, width - marginRight])

// Declare the y (vertical position) scale.
const y = d3.scaleLinear()
    .domain([minT, maxT])
    .range([height - marginBottom, marginTop]);

// Create the SVG container.
const svg = d3.create("svg")
    .attr("width", width)
    .attr("height", height);

// Add the x-axis.
svg.append("g")
    .attr("transform", `translate(0,${((height)/2)-0})`)
    .call(d3.axisBottom(x));

// Add the y-axis.
svg.append("g")
    .attr("transform", `translate(${(width)/2},0)`)
    .call(d3.axisLeft(y));


// Draw a light line

// Draw a Light like line ct
svg.append("line")
    .style("stroke", "gray")
    .attr("x1", x(minX))
    .attr("x2", x(maxX))
    .attr("y1", y(minT))
    .attr("y2", y(maxT));

// Draw a Light like line -ct
svg.append("line")
    .style("stroke", "gray")
    .attr("x1", x(maxX))
    .attr("x2", x(minX))
    .attr("y1", y(minT))
    .attr("y2", y(maxT));

// Your World Line (Vertical)
svg.append("line")
    .style("stroke", "red")
    .style("stroke-width", "3")
    .attr("x1", x(0))
    .attr("x2", x(0))
    .attr("y1", y(minT))
    .attr("y2", y(maxT));

// Other Reference Frame World Line (Vertical)
svg.append("line")
    .style("stroke", "blue")
    .style("stroke-width", "3")
    .attr("x1", x(-5))
    .attr("x2", x(5))
    .attr("y1", y(minT))
    .attr("y2", y(maxT));

/*
// 2024-09-27 Brockman - Customization to add a few demonstraton points

var points = [
    { date: new Date("2023-07-15"), amount : 24 },
    { date: new Date("2023-10-15"), amount : 49 },
    { date: new Date("2023-03-15"), amount : 15 },
    { date: new Date("2023-01-15"), amount : 88 },
];

svg.append("g")
    .selectAll("dot")
    .data(points)
    .join("circle")
    .attr("cx", function (d) { return x(d.date); })
    .attr("cy", function (d) { return y(d.amount); })
    .attr("r", 6.0 )
    .style("fill", "#6943a2");

points.forEach(function(d) {
    console.log("Point: ", d);
});
*/

// Append the SVG element.
container.append(svg.node());
