# README Spacetime Java to Web Conversion Planning 

Ideas from a Zoom on Friday May 31, 2024, about the approach to begin converting the SpaceTime Java application to run in a web browser.

Jonathan Bennett, Taylor Brockman


## Milestone 1: Translate the Mathematics from Java to Typescript

1. Open Java Source Code

Zip file:  Spacetime src 2024-05-24.zip

Here are the source files:

- DrawingPanel.java
- DrawingPanelDiagram.java
- DrawingPanelHighway.java
- EventTable.java
- HelpFrame.java
- HistoryWriter.java
- ObjectTable.java
- STBetaChangeEvent.java
- STClock.java
- STDiagramDecoration.java
- STEvent.java
- STFlash.java
- STHyperbola.java
- STInterval.java
- STLightCone.java
- STObject.java
- Scenario.java
- ScenarioFileFilter.java
- SpacetimeApp.java
- WorldlineRecord.java

2. Read and Understand Source Code

Illuminating to step through the source code in an IDE in Debug Mode with Breakpoints:

IntelliJ - https://www.jetbrains.com/idea/

To set a 'Breakpoint' in Idea, click to the left of the code line number and a red circle appears.  When the application is active in debug mode, code execution will stop at all breakpoints and allow the developer to inspect variables and step over or resume code execution.

Example: STEvent.java, lines 40-51

```
public STEvent(Scenario sc, double xp, double tp){
    this.sc = sc;
    this.pnlHighway = sc.app.pnlHighway;
    this.pnlDiagram = sc.app.pnlDiagram;
    double betaRel = sc.getBetaRel();
    double gammaRel=1/Math.sqrt(1-betaRel*betaRel);
    
    this.x=gammaRel*(xp + betaRel*tp);
    this.t=gammaRel*(tp + betaRel*xp);
    
    tol = sc.app.TOLERANCE;
  }
```

I compiled the java source with:
```
javac spacetime/*java
```


3. Translate Source Code using Chat GPT

Reading: https://www.codecademy.com/article/translate-code-into-different-languages-with-chat-gpt

Prompt: I need your help translating Java code to Typescript.


4. Build new unit tests in Java + Typescript for the scenarios.

Unit tests are small programs that test the inputs and outputs of functions. 

Unit tests are a best practice because they make sure the fundamental assumptions are always correct (the mathematics) and they can be run with every code code to make sure nothing broke.

We would use these unit tests to make sure that our Java output and Typescript outputs make sense and they match.


## Milestone 2: Graphical Programming for the Web

When the students arrive, they could learn web animation programming using D3.js or other.

The goal of this would to build the two charts in the application:
- Highway
- Spacetime Diagram


## Milestone 3: Compose the Web User Interface to build the Animator

Students could then learn web application programming using React.js or similar to compose all the different elements: Mathematics, Charts, and Output Tables.


The goal would be to have the SpacetimeScenarios animatable on the web:

- Runner on the train.sce
- Simultaneity.sce
- Train Ground.sce * Favorite
- Trip to Alpha.sce
- Twin paradox with flashes.sce
- Twin paradox.sce
- accelerating rod scenario 1.sce
- accelerating rod scenario 2.sce
- addition of velocities.sce
- beacon.sce
- flickering bulb paradox.sce
- paradox of the identically accelerated twins.sce
- space war.sce



