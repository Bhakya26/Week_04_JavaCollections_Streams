import java.util.regex.*;

public class ValidUsername {
    public static boolean isValidUsername(String username) {
        return Pattern.matches("^[a-zA-Z][a-zA-Z0-9_]{4,14}$", username);
    }

    public static void main(String[] args) {
        System.out.println(isValidUsername("user_123")); // true
    }
}