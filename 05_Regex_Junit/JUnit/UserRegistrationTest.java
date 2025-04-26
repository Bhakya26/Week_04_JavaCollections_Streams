package test;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserRegistrationTest {

    private final UserRegistration registration = new UserRegistration();

    @Test
    void testValidUserRegistration() {
        assertDoesNotThrow(() -> registration.registerUser("validUser", "user@example.com", "Password123"));
    }

    @Test
    void testEmptyUsernameThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> registration.registerUser("", "user@example.com", "Password123"));
    }

    @Test
    void testInvalidEmailThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> registration.registerUser("validUser", "invalid-email", "Password123"));
        assertThrows(IllegalArgumentException.class, () -> registration.registerUser("validUser", "user@example", "Password123"));
    }

    @Test
    void testShortPasswordThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> registration.registerUser("validUser", "user@example.com", "short"));
    }

    @Test
    void testNullUsernameThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> registration.registerUser(null, "user@example.com", "Password123"));
    }

    @Test
    void testNullEmailThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> registration.registerUser("validUser", null, "Password123"));
    }

    @Test
    void testNullPasswordThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> registration.registerUser("validUser", "user@example.com", null));
    }
}
