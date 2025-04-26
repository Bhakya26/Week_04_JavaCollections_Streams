package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    public void testAdd() {
        assertEquals(5, calculator.add(2, 3));
        assertEquals(0, calculator.add(-2, 2));
    }

    @Test
    public void testSubtract() {
        assertEquals(1, calculator.subtract(5, 4));
        assertEquals(-1, calculator.subtract(2, 3));
    }

    @Test
    public void testMultiply() {
        assertEquals(6, calculator.multiply(2, 3));
        assertEquals(0, calculator.multiply(0, 100));
    }

    @Test
    public void testDivide() {
        assertEquals(2, calculator.divide(6, 3));
        assertEquals(-2, calculator.divide(6, -3));
    }

    @Test
    public void testDivideByZero() {
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            calculator.divide(10, 0);
        });
        assertEquals("Division by zero is not allowed.", exception.getMessage());
    }
}

