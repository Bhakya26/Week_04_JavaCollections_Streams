package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MathUtilsTest {

    @Test
    void testDivideByZeroThrowsException() {
        MathUtils mathUtils = new MathUtils();

        ArithmeticException exception = assertThrows(
            ArithmeticException.class,
            () -> mathUtils.divide(10, 0),
            "Expected divide() to throw, but it didn't"
        );

        assertEquals("Division by zero is not allowed.", exception.getMessage());
    }

    @Test
    void testDivideValidInput() {
        MathUtils mathUtils = new MathUtils();
        assertEquals(5, mathUtils.divide(10, 2), "10 divided by 2 should be 5");
    }
}
