import java.util.*;
import java.io.*;
public class MultipleCatch {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int[] arr= {1,2,3,4,5};
		try {
			System.out.println("Enter the index");
			int index=sc.nextInt();
			int value=arr[index];
			System.out.println("Indexx: "+index+" >>value "+value);
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Invalid index");
		}catch(NullPointerException e) {
			System.out.println("Array is not initialized");
		}finally {
			sc.close();
		}
	}

}
