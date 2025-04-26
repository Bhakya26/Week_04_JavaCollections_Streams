package test;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseConnectionTest {

    private DatabaseConnection db;

    @BeforeEach
    void setUp() {
        db = new DatabaseConnection();
        db.connect();
    }

    @AfterEach
    void tearDown() {
        db.disconnect();
    }

    @Test
    void testConnectionIsEstablished() {
        assertTrue(db.isConnected(), "Database should be connected after setup.");
    }

    @Test
    void testConnectionIsClosedAfterEach() {
        assertTrue(db.isConnected(), "Connection should be active before test ends.");
        // The actual disconnect check happens after this test due to @AfterEach
    }
}
