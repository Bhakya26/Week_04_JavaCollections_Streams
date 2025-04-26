import java.util.regex.*;

public class ValidSSN {
    public static boolean isValidSSN(String ssn) {
        return Pattern.matches("\\b\\d{3}-\\d{2}-\\d{4}\\b", ssn);
    }

    public static void main(String[] args) {
        System.out.println(isValidSSN("123-45-6789")); // true
    }
}
