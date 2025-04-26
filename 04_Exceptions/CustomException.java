import java.util.*;

class InvalidAgeException extends Exception{
	public InvalidAgeException(String message) {
		super(message);
	}
	
}
public class CustomException {
	public static void validAge(int age) throws InvalidAgeException{
		if(age<18) {
			throw new InvalidAgeException("age must be equal to 18 or above");
		}
		}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		try {
			System.out.println("Enter your age");
			int age=sc.nextInt();
			validAge(age);
            System.out.println("Access granted!");
            }
		catch(InvalidAgeException e) {
			System.out.println(e.getMessage());
		}
	finally {
		sc.close();
	}
	}

}
