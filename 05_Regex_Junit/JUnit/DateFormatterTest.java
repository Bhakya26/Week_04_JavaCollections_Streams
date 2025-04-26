package test;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DateFormatterTest {

    private final DateFormatter formatter = new DateFormatter();

    @Test
    void testValidDateFormatting() {
        assertEquals("25-12-2023", formatter.formatDate("2023-12-25"));
        assertEquals("01-01-2024", formatter.formatDate("2024-01-01"));
    }

    @Test
    void testInvalidDateThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> formatter.formatDate("12/25/2023"));
        assertThrows(IllegalArgumentException.class, () -> formatter.formatDate("2023.12.25"));
        assertThrows(IllegalArgumentException.class, () -> formatter.formatDate("invalid-date"));
    }

    @Test
    void testNullDateThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> formatter.formatDate(null));
    }
}
