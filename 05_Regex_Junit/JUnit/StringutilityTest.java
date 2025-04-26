package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringutilityTest {

    @Test
    public void testReverse() {
        assertEquals("cba", Stringutility.reverse("abc"));
        assertEquals("", Stringutility.reverse(""));
        assertNull(Stringutility.reverse(null));
    }

    @Test
    public void testIsPalindrome() {
        assertTrue(Stringutility.isPalindrome("madam"));
        assertTrue(Stringutility.isPalindrome("RaceCar")); // case-insensitive
        assertFalse(Stringutility.isPalindrome("hello"));
        assertFalse(Stringutility.isPalindrome(null));
    }

    @Test
    public void testToUpperCase() {
        assertEquals("HELLO", Stringutility.toUpperCase("hello"));
        assertEquals("", Stringutility.toUpperCase(""));
        assertNull(Stringutility.toUpperCase(null));
    }
}

