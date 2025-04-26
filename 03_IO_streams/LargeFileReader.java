import java.io.*;

public class LargeFileReader {
    public static void main(String[] args) {
        String fileName = "largeFile.txt";  

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.toLowerCase().contains("error")) {  
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
