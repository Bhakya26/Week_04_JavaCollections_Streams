import java.io.*;
public class FileHandling {
	public static void main(String[] args) {
		String sourcepath="source.txt";
		String destinationpath="destination.txt";
		FileInputStream toread=null;
		FileOutputStream towrite=null;
		try {
			File sourcefile=new File(sourcepath);
			if(!sourcefile.exists()) {
				System.out.println(sourcepath+" file not exists or not found");
				return;
			}
			toread=new FileInputStream(sourcepath);
			towrite=new FileOutputStream(destinationpath);
			int data;
			while((data=toread.read())!=-1) {
				towrite.write(data);
			}
			System.out.println("File copied successfully");
		}
		catch(IOException e){
			System.out.println("Error occured!!"+e.getMessage());
		}
		finally {
			try {
				if(toread!=null) {
					toread.close();
				}
				if(towrite!=null) {
					towrite.close();
				}
			}
			catch(IOException e) {
				System.out.println("unable to close!!"+e.getMessage());
			}
			
		}
	}

}
