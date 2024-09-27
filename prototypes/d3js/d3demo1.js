// Reference: https://d3js.org/getting-started
// Reference: https://medium.com/@john.goodman/getting-started-with-d3-js-6de226320878

// Declare the chart dimensions and margins.
const width = 640;
const height = 400;
const marginTop = 20;
const marginRight = 20;
const marginBottom = 30;
const marginLeft = 40;

// Declare the x (horizontal position) scale.
const x = d3.scaleUtc()
    .domain([new Date("2023-01-01"), new Date("2024-01-01")])
    .range([marginLeft, width - marginRight]);

// Declare the y (vertical position) scale.
const y = d3.scaleLinear()
    .domain([0, 100])
    .range([height - marginBottom, marginTop]);

// Create the SVG container.
const svg = d3.create("svg")
    .attr("width", width)
    .attr("height", height);

// Add the x-axis.
svg.append("g")
    .attr("transform", `translate(0,${height - marginBottom})`)
    .call(d3.axisBottom(x));

// Add the y-axis.
svg.append("g")
    .attr("transform", `translate(${marginLeft},0)`)
    .call(d3.axisLeft(y));


// 2024-09-27 Brockman - Customization to add a few demonstraiton points

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


// Append the SVG element.
container.append(svg.node());
