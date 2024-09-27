// https://symflower.com/en/company/blog/2023/how-to-write-junit-test-cases/
package examples;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class TriangleTest {
    @Test
    public void isValidNegativeSide() {
        Triangle t = new Triangle(1, 1, -1);
        boolean expected = false;
        boolean actual = t.isValid();

        assertEquals(expected, actual);
    }
}
