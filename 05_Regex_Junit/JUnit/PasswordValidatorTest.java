package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PasswordValidatorTest {

    private final PasswordValidator validator = new PasswordValidator();

    @Test
    void testValidPassword() {
        assertTrue(validator.isValid("Password1"), "Valid password should return true");
    }

    @Test
    void testTooShortPassword() {
        assertFalse(validator.isValid("Pass1"), "Password too short should return false");
    }

    @Test
    void testNoUppercasePassword() {
        assertFalse(validator.isValid("password1"), "Password without uppercase should return false");
    }

    @Test
    void testNoDigitPassword() {
        assertFalse(validator.isValid("Password"), "Password without digit should return false");
    }

    @Test
    void testNullPassword() {
        assertFalse(validator.isValid(null), "Null password should return false");
    }
}
