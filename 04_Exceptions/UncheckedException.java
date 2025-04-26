import java.util.*;
public class UncheckedException {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		try {
			System.out.println("Enter numerator");
			int num=sc.nextInt();
			System.out.println("Enter denominator");
			int den=sc.nextInt();
			
			int div=num/den;
			System.out.println("Division: "+div);
		}catch(ArithmeticException e){
			System.out.println("Error: cannot divide by zero");
			}
		catch(InputMismatchException e) {
			System.out.println("Error: enter numeric values only");
		}finally {
			sc.close();
		}
	}

}
