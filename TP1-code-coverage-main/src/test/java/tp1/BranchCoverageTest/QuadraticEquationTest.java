package tp1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuadraticEquationTest {

    @Test
    void testAIsZero() {
        assertThrows(IllegalArgumentException.class, () -> QuadraticEquation.solve(0, 2, 3));
    }

    @Test
    void testNoRealRoots() {
        assertNull(QuadraticEquation.solve(1, 0, 1)); // delta < 0
    }

    @Test
    void testSingleRoot() {
        double[] roots = QuadraticEquation.solve(1, 2, 1); // delta == 0
        assertEquals(1, roots.length);
        assertEquals(-1.0, roots[0]);
    }

    @Test
    void testTwoRoots() {
        double[] roots = QuadraticEquation.solve(1, -3, 2); // delta > 0
        assertEquals(2, roots.length);
        assertTrue((roots[0] == 2.0 && roots[1] == 1.0) || (roots[0] == 1.0 && roots[1] == 2.0));
    }
}