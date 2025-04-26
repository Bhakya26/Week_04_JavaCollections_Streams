import java.io.*;

public class BufferedStreams {
    public static void main(String[] args) {
        String sourcePath = "largefile.txt";        
        String destinationBuffered = "copy_buffered.txt";
        String destinationUnbuffered = "copy_unbuffered.txt";

        copyUsingUnbufferedStreams(sourcePath, destinationUnbuffered);
        copyUsingBufferedStreams(sourcePath, destinationBuffered);
    }

    public static void copyUsingUnbufferedStreams(String source, String destination) {
        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(destination)) {

            long startTime = System.nanoTime();

            int data;
            while ((data = fis.read()) != -1) {
                fos.write(data);
            }

            long endTime = System.nanoTime();
            System.out.println("Unbuffered Copy Time: " + (endTime - startTime) / 1_000_000 + " ms");

        } catch (IOException e) {
            System.out.println("Error during unbuffered copy: " + e.getMessage());
        }
    }

   
    public static void copyUsingBufferedStreams(String source, String destination) {
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destination))) {

            byte[] buffer = new byte[4096]; 
            int bytesRead;

            long startTime = System.nanoTime();

            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }

            long endTime = System.nanoTime();
            System.out.println("Buffered Copy Time: " + (endTime - startTime) / 1_000_000 + " ms");

        } catch (IOException e) {
            System.out.println("Error during buffered copy: " + e.getMessage());
        }
    }
}
