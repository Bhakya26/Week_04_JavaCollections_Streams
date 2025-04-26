import java.util.*;
import java.util.regex.*;

public class ValidCreditCard {
    public static boolean isValidCreditCard(String card) {
        return Pattern.matches("^4\\d{15}$", card) || Pattern.matches("^5\\d{15}$", card);
    }

    public static void main(String[] args) {
        System.out.println(isValidCreditCard("4111111111111111")); // true
    }
}
