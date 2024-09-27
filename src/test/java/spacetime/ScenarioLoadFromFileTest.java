// https://symflower.com/en/company/blog/2023/how-to-write-junit-test-cases/
package spacetime;

import examples.Triangle;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.Path;

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
        Scenario scenario = new Scenario( app );
        scenario.loadFromFile(sceTestFile);

        // Test that the objects were loaded in
        assertEquals( scenario.objects.size(), 3 );
        assertEquals( scenario.events.size(), 5 );
        assertEquals( scenario.decorations.size(), 0 );

        boolean breaker22=true;


        // Not implemented
        // fail("Not Implemented");

    }


}
