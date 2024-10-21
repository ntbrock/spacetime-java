Call 2024-10-21 Coordinate System Translations

## Agenda

* Dr. Bennett > Mathematics of Lorentz translations

* Taylor > YouTube: The Time Globe https://youtu.be/Rh0pYtQG5wI?t=562
	9m 22s

* Devs> Review the Spacetime Calculations called Worldline Records.  Start with code in src/test/java/spacetime/ScenarioLoadFromFileTest, lines 128 - 130 where the Java calculations are called.

* Taylor> Graphical Coordinate Systems Discussion


---
# Details


## Mathematics of Lorentz translations

(4 Pages from Modern Physics)

## YouTube Lorentz Transformations Special Relativity Ch. 3.

https://www.youtube.com/watch?v=Rh0pYtQG5wI

Key: Lorentz spacetime diagram: It's your reference frame if Your worldline is a vertical line at x = 0.

To transform the diagram to a different reference frame, it's about translating the destination reference frame to x = 0 vertically.

Rotating the snapshots, make the angles between the two frames remain the same.

Shear transformations (Can't accomodate lightspeed constant) -> Boost Transformation.

(Maxwell's equations.)

The unchanged speed = c.

The slope of the worldlines of c remains unchanged.

Possible for all speeds to change except 1.


Squeeze rotations.

1sec vertical tick
299,492,458m horizontal tick 

9m 25seconds - physical device = The time globe.

"Boost into the cat's perspective"


## Review the Spacetime Calculations called Worldline Records

```java  
  public double getXp(){
    double betaRel = sc.getBetaRel();
    double gammaRel = 1/Math.sqrt(1-betaRel*betaRel);
    return gammaRel*(x-betaRel*t);
  }
  
  public double getTp(){
    double betaRel = sc.getBetaRel();
    double gammaRel = 1/Math.sqrt(1-betaRel*betaRel);
    return gammaRel*(t-betaRel*x);
  }
```

Jumped out to reference : STObject.java, LIne 422 addWorldlineRecord:

Line 602:       STEvent ev = new STBetaChangeEvent(sc, this, tp);

Jumped to ST Beta Change Event.java line 28:   public void drawInHighway(Graphics2D g2){

Java 2D Api Overview: https://docs.oracle.com/javase/8/docs/technotes/guides/2d/spec/j2d-intro.html



## Graphical Coordinate Systems Discussion

### Definition

Illustrating spatial properties of a physical system into a visualization to assist in understanding and navigation.

Requires a 'transformation' function from the physical system into the visualization and visa-versa.

### Examples

Mercator Projections - Illustrations of the Earth, which is approximately spherical into a 
conformal cylindrical map, and put onto flat paper.  Mercator navigation: Straight lines on the project represent an actual compass bearing.   Lat/Lon Coordinates.

Computer Graphics Displays - Looking through a flat display of pixels into an image or a rendering. Graphical displays typically origin at pixel 0,0 at the top left of the screen or a window and the coordinates increasing as you move right and down.  No negative coordinates.

Raster coordinate systems (pixels, Jpeg Images, Digital Cameras) are discrete, Vector coordinate systems (PDF Files, Scalable Vector Graphics), are continuous.

( Use Case: Resizing of an application window, or viewing a web page on your Smartphone )

### Information Theory

While the information in the physical system is 'complete', the illustration is always 'partial' and possibly focused on a key aspect, but adds capabilities with the ability to overlay and annotate.

( Use case: Panning and Zooming in a Geographical Mapping Application (Like Google Maps) )

### Software Design Considerations

Separation of Concerns - There exists a translation layer or function that is encapsulated with a good interface and testable in code that has all the required calculations to translate between the physical system and the illustration.

https://en.wikipedia.org/wiki/Separation_of_concerns

Bidirectional - The translation layer can be used both to translate from System to Illustration and Illustration to System to enable user input such as mouse clicks or touch events to be evaluated in the coordinates of the system.

Dimension Reduction - The translation layer may reduce the number of dimensions of the physical system using a projection. Example = Showing a globe on a flat panel display.  Example 2 - Playing a first person perspective open-world game on a television: Minecraft.

View Port - The flat panel display may only be illustrating a small view into or component of the physical system. The computer / flat panel may have multiple multiple windows, multiple graphical displays (2 monitors), 

https://developer.mozilla.org/en-US/docs/Web/CSS/Viewport_concepts

Animation - The translation layer may show the physical system changing over time or through a series of modifications. Example: Video and audio editing.  Considerations are required for the user interface to move forward, backwards, and jump around within the available time period.

### References

Java Coordinate Systems:
https://docs.oracle.com/javase/8/docs/technotes/guides/2d/spec/j2d-intro.html#wp61857

You can add an AffineTransform to the graphics context to rotate, scale, translate, or shear a geometric shape, text, or image when it is rendered. The added transform is applied to any graphic object rendered in that context. The transform is performed when user space coordinates are converted to device space coordinates.


SVG (d3.js) Coordinate systems:
https://benclinkinbeard.com/d3tips/understanding-svg-coordinate-space/

In SVG (and canvas, etc.), 0,0 is the top left corner. X values increase as they move to the right and Y values increase as they move down.

