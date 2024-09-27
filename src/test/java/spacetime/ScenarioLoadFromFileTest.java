// https://symflower.com/en/company/blog/2023/how-to-write-junit-test-cases/
package spacetime;

import examples.Triangle;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * 2024-09-27 Brockman - Implemented the Standard Example of a JUnit Test
 */

public class ScenarioLoadFromFileTest {
    // Example of src/test/resources files living in a subdirectory that matches the test class name.
    Path resourcePath = Path.of("src", "test", "resources", this.getClass().getSimpleName() );

    @Test
    public void loadScenarioTripToAlpha() {

        File sceTestFile = new File(resourcePath + File.separator + "Test_Trip_to_Alpha.sce");
        assertEquals( sceTestFile.exists(), true );

        // Example of Initializing the SpacetimeApp JFrame
        SpacetimeApp app = new SpacetimeApp();
        app.setSize(1000,700);
        app.initialize();
        // Not Setting Visible for testing
        app.setVisible(false);

        // Create a New Scenario Object that we'll use to read the sce file.
        // Scenario scenario = new Scenario( app );
        // Fix: Use the scenario already created in the app, rather than constructing a new one
        Scenario scenario = app.sc;
        scenario.loadFromFile(sceTestFile);

        // Test that the objects were loaded in
        assertEquals( scenario.objects.size(), 3 );
        assertEquals( scenario.events.size(), 5 );
        assertEquals( scenario.decorations.size(), 0 );

        // Check the Clock Names and Labels
        for ( int i = 0 ; i < scenario.objects.size(); i++) {
            STObject o = (STObject) scenario.objects.get(i);

            if ( i == 0 ) {
                // C1 Earth Clock
                assertEquals( o.getClass().getSimpleName(), "STClock");
                assertEquals( o.getName(), "C1" );
                assertEquals( o.getLabel(), "Earth" );

            } else if ( i == 1 ) {
                boolean breaker56=true;
                // C2 Alpha Clock
                assertEquals( o.getClass().getSimpleName(), "STClock");
                assertEquals( o.getName(), "C2" );
                assertEquals( o.getLabel(), "Alpha" );


            } else if ( i == 2 ) {
                boolean breaker64=true;
                // C3 Rocket Clock
                assertEquals( o.getClass().getSimpleName(), "STClock");
                assertEquals( o.getName(), "C3" );
                assertEquals( o.getLabel(), "Rocket" );

            } else {
                fail("Unexpected object at index: " + i + " : " + o );
            }

        }
    }


    @Test
    public void animateScenarioTripToAlpha() {

        // Test Initialization
        String scenarioFilename = "Test_Trip_to_Alpha.sce";
        long sleepTimeMs = 500L;  // 50L
        int maxSteps = 25;  // 250

        // Memory object storage for all events
        LinkedList<STObjectCalculationsAtTime> calculations = new LinkedList();

        File sceTestFile = Path.of( resourcePath.toString(), scenarioFilename).toFile();
        assertEquals( sceTestFile.exists(), true );

        // Example of Initializing the SpacetimeApp JFrame
        SpacetimeApp app = new SpacetimeApp();
        app.setSize(1000,700);
        app.initialize();
        // While developing tests, set visible to see what is going on.
        app.setVisible(true);

        // Create a New Scenario Object that we'll use to read the sce file.
        // Scenario scenario = new Scenario( app );
        // Fix: Use the scenario already created in the app, rather than constructing a new one
        Scenario scenario = app.sc;
        scenario.loadFromFile(sceTestFile);
        app.repaint();
        app.objectTable.updateTable();
        app.eventTable.updateTable();

        // Step The Animation Forward
        try {


            for ( int step = 0; step < maxSteps; step++ ) {
                // Write the Object Table Properties?

                double referenceFrameTime = app.t;
                // Check the Clock Names and Labels
                for ( int i = 0 ; i < scenario.objects.size(); i++) {

                    STObject o = (STObject) scenario.objects.get(i);
                    STObjectCalculationsAtTime calc = new STObjectCalculationsAtTime(
                        scenarioFilename,
                        o.getName(),
                        o.getLabel(),
                        referenceFrameTime,
                        o.getTimeReading(referenceFrameTime),
                        o.getXpAtTp(referenceFrameTime),
                        o.getBetaP(referenceFrameTime),
                        o.getGammaP(referenceFrameTime)
                    );
                    // Keep the list of all calculations
                    calculations.add(calc);

                    // Demonstration on 2024-09-27: Debugging C3 Rocket Clock
                    if ( i == 2 ) {
                        boolean breaker64 = true;
                    }
                }

                // Step Animation Forward
                app.stepForward();
                app.repaint();
                Thread.sleep(sleepTimeMs);
            }

        } catch ( InterruptedException x ) {
            System.err.println("Caught: " + x );
        }

        app.setVisible(false);

        // Animation Complete: Ensure we have all the calculation history we are expecting.
        String csvFilename = scenarioFilename.replaceAll("[.]sce$", ".csv");
        try {
            STObjectCalculationsCsv.writeToCsvFile(Path.of(resourcePath.toString(), csvFilename).toFile(), calculations);
        } catch ( IOException x ) {
            fail(x);
        }

        boolean breaker148=true;

    }

    // Not implemented
    // fail("Not Implemented");
}
