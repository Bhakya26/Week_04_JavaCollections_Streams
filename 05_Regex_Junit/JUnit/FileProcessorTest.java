package test;

import org.junit.jupiter.api.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class FileProcessorTest {

    private static final String TEST_FILE = "test_file.txt";
    private FileProcessor processor;

    @BeforeEach
    void setUp() {
        processor = new FileProcessor();
    }

    @AfterEach
    void cleanUp() throws IOException {
        Files.deleteIfExists(Paths.get(TEST_FILE));
    }

    @Test
    void testWriteAndReadFile() throws IOException {
        String content = "Hello, world!";
        processor.writeToFile(TEST_FILE, content);

        assertTrue(Files.exists(Paths.get(TEST_FILE)), "File should exist after writing");

        String readContent = processor.readFromFile(TEST_FILE);
        assertEquals(content, readContent, "Content read should match content written");
    }

    @Test
    void testReadNonExistentFileThrowsIOException() {
        String nonExistentFile = "no_such_file.txt";
        assertThrows(IOException.class, () -> processor.readFromFile(nonExistentFile),
                "Reading a non-existent file should throw IOException");
    }
}
