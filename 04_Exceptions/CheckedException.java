import java.io.*;
public class CheckedException {
	public static void main(String[] args) {
		String filename="data.txt";
		try(BufferedReader reader=new BufferedReader(new FileReader(filename))){
			String line;
			System.out.println("read file contents");
			while((line=reader.readLine())!=null) {
				System.out.println(line);
			}
		}catch(IOException e) {
			System.out.println("File not found");
		}
	}

}
