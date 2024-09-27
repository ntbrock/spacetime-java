Call 2024-09-27 Spacetime Maven Github JUnit d3

## Next Actions 9/27

* Justin> Review the Spacetime Calculations called Worldline Records.  Start with code in src/test/java/spacetime/ScenarioLoadFromFileTest, lines 128 - 130 where the Java calculations are called.

* Dr. Bennett> Share pages to read on Worldlines. Continue to think about the Screenshots being embedded in the Course Material.

* Taylor> Email Brandon get him up to speed.

* Brandon> Git Pull, Run the example and spacetime Unit Tests in IntelliJ.


## Next Meetings

- October 4: No Meeting, Fall Break

- October 11th: Full Team

- October 18: Developers, Dr. Bennett will be at a physics conference.

- October 25: No Meeting, Dr. Bennett Physics, Taylor Alumni Weekend,.


Roadmap: Making progress towards running some new code. Milestones:

- Build a Spacetime diagram or a Superhighway and build it in d3.  Considerations are Axes, Animations, and which objects are shown.

- Build a step-wise calculator in Javascript/Typescript that calculates t, x, and beta for the three trip to alpha clocks.  It's output should match the Spacetime Java csv output.






## Next Actions 9/20
 
* Dr. Bennett> Consider Adding Spacetime diagrams into the Trainground Lab 1 + 2  Google Docs

	Gathering ideas, the things we've gone through together with train ground.
	Screenshots from Spacetime diagrams.

* Taylor> Get my JUnit test working + Push pom.xml
 
* Justin + Brandon> Try a JUnit test in IntelliJ. 
 
Reference: https://symflower.com/en/company/blog/2023/how-to-write-junit-test-cases/
 
* Together Next Week> Review Spacetime code and see where we could write out a CSV file that has all the values of all the events.
 

## Taylor Demonstrations on 9/27

- Lab Assignments in Markdown and Word: course-materials

- Prototype d3.js in IntelliJ Html Editor + Preview

- Maven Pom.xml and Source Code Directory Conventions
```sh
mvn clean compile test
```
- Github Actions, Artifact Download

- Example JUnit Test: TriangleTest 

- Spacetime JUnit Test: ScenarioLoadFromFileTest and the CSV Output Test.


	Assume SpaceTime java is correct.

	Build Spacetime Web -> 1. Build the mathematrics,    2. Build the Trip to Alpha Scenario.

	3. OUtput a CSV file at all values of all animation steps.

	4. Compare Spacetime java csv -vs- Spacetime web csv, they should match!



### Review Spacetime code and see where we could write out a CSV file that has all the values of all the events.

Design Pattern : Inspection, peek in to minimize the modifications to the original code.



Code Highlights:

1. Found the Key keyPressed event handler to see how to advance time.

SpacetimeApp.java, line 952:

else if (key == KeyEvent.VK_UP) {  // shift time one step forward
      if(!shiftPressed){
        stepForward();
        repaint();
        historyWriter.continueWriting();

2. Found Calculations Deep in the ObjectTable code

          else if(col==1) {//xp
            double tp = sc.app.t;
            double betap = d.getBetaP(sc.app.t);
            double oldXp = d.getXpAtTp(sc.app.t);
            double xp;
            try{

3. Designed a Csv Output Model


## Next Actions

* Justin> Review the Spacetime Calculations called Worldline Records.  Start with code in src/test/java/spacetime/ScenarioLoadFromFileTest, lines 128 - 130 where the Java calculations are called.

* Dr. Bennett> Share pages to read on Worldlines. Continue to think about the Screenshots being embedded in the Course Material.

* Taylor> Email Brandon get him up to speed.

* Brandon> Git Pull, Run the example and spacetime Unit Tests in IntelliJ.


## Next Meetings:

- October 11th: Full Team

- October 18: Developers, Dr. Bennett will be at a physics conference.

- October 25: No Meeting, Dr. Bennett Physics, Taylor Alumni Weekend,.


Roadmap: Making progress towards running some new code. Milestones:

- Build a Spacetime diagram or a Superhighway and build it in d3.  Considerations are Axes, Animations, and which objects are shown.

- Build a step-wise calculator in Javascript/Typescript that calculates t, x, and beta for the three trip to alpha clocks.  It's output should match the Spacetime Java csv output.




