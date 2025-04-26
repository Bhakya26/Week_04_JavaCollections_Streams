import java.util.regex.*;

public class ValidLicense {
    public static boolean isValidLicensePlate(String plate) {
        return Pattern.matches("^[A-Z]{2}[0-9]{4}$", plate);
    }

    public static void main(String[] args) {
        System.out.println(isValidLicensePlate("AB1234")); // true
    }
}