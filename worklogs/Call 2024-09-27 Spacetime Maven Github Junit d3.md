Call 2024-09-27


## Next Actions
 
* Dr. Bennett> Add Spacetime diagrams into the Trainground Lab 1 + 2  Google Docs
 
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

- Example JUnit Test: TriangleTest 

- Spacetime JUnit Test: ScenarioLoadFromFileTest

- Github Actions, Artifact Download




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


