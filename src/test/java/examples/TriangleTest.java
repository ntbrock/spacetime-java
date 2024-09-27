// https://symflower.com/en/company/blog/2023/how-to-write-junit-test-cases/
package examples;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * 2024-09-27 Brockman - Implemented the Standard Example of a JUnit Test
 */

public class TriangleTest {
    @Test
    public void isValidNegativeSide() {
        Triangle t = new Triangle(1, 1, -1);
        boolean expected = false;
        boolean actual = t.isValid();

        assertEquals(expected, actual);
    }

    @Test
    public void isValidLargeTriangle() {
        Triangle t = new Triangle(1000, 2000, 3000);
        assertEquals(t.isValid() , true);
    }

}
