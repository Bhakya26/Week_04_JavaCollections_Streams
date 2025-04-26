package test;

public class TaskProcessor {

    public String longRunningTask() throws InterruptedException {
        Thread.sleep(3000); // Sleep for 3 seconds
        return "Task Completed";
    }
}

