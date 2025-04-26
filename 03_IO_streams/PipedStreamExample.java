import java.io.*;

public class PipedStreamExample {
    public static void main(String[] args) {
        PipedOutputStream pos = new PipedOutputStream();
        PipedInputStream pis = new PipedInputStream();

        try {
            pis.connect(pos); // Connect the streams so they can communicate

            Thread writerThread = new Thread(new WriterThread(pos));
            Thread readerThread = new Thread(new ReaderThread(pis));

            writerThread.start();
            readerThread.start();

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

class WriterThread implements Runnable {
    private PipedOutputStream pos;

    public WriterThread(PipedOutputStream pos) {
        this.pos = pos;
    }

    @Override
    public void run() {
        String message = "Hello from Writer Thread!";
        try {
            for (char ch : message.toCharArray()) {
                pos.write(ch); // Write each character
                Thread.sleep(100); // Simulate some delay
            }
            pos.close(); // Close the stream after writing
        } catch (IOException | InterruptedException e) {
            System.out.println("Error in WriterThread: " + e.getMessage());
        }
    }
}

class ReaderThread implements Runnable {
    private PipedInputStream pis;

    public ReaderThread(PipedInputStream pis) {
        this.pis = pis;
    }

    @Override
    public void run() {
        try {
            int data;
            while ((data = pis.read()) != -1) { // Read data until the end
                System.out.print((char) data); // Print the character
                Thread.sleep(150); // Simulate some delay
            }
            pis.close(); // Close the stream after reading
        } catch (IOException | InterruptedException e) {
            System.out.println("Error in ReaderThread: " + e.getMessage());
        }
    }
}
