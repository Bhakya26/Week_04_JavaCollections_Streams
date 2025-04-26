package day7problems;


interface SquareCalculator {
    // Abstract method to calculate square
    int square(int number);

    // Default method to print result with a message
    default void printSquare(int number) {
        int result = square(number);
        System.out.println("The square of " + number + " is: " + result);
    }
}

public class CustomFI {
    public static void main(String[] args) {
        // Using lambda expression to implement square method
        SquareCalculator calculator = n -> n * n;

        // Call the default method
        calculator.printSquare(7);  // Example: 7
    }
}
