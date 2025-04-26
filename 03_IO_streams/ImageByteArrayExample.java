import java.io.*;

public class ImageByteArrayExample {
    public static void main(String[] args) {
        String inputImagePath = "original_image.jpg";
        String outputImagePath = "copied_image.jpg";

        try {
            byte[] imageBytes = readImageToByteArray(inputImagePath);
            writeByteArrayToImage(imageBytes, outputImagePath);
            System.out.println("Image copied successfully!");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static byte[] readImageToByteArray(String imagePath) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try (FileInputStream fis = new FileInputStream(imagePath)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }
        }
        return baos.toByteArray();
    }

    public static void writeByteArrayToImage(byte[] imageBytes, String outputPath) throws IOException {
        try (ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
             FileOutputStream fos = new FileOutputStream(outputPath)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = bais.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        }
    }
}
