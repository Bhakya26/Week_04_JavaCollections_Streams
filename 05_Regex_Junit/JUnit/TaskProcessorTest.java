package test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class TaskProcessorTest {

    @Test
    @Timeout(value = 2, unit = TimeUnit.SECONDS)
    void testLongRunningTaskTimeout() throws InterruptedException {
        TaskProcessor processor = new TaskProcessor();
        processor.longRunningTask(); // This should fail due to timeout
    }
}

