package test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

class NumberUtilsTest {

    private final NumberUtils utils = new NumberUtils();

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6})
    void testIsEvenTrueCases(int number) {
        assertTrue(utils.isEven(number), number + " should be even");
    }

    @ParameterizedTest
    @ValueSource(ints = {7, 9})
    void testIsEvenFalseCases(int number) {
        assertFalse(utils.isEven(number), number + " should be odd");
    }
}
