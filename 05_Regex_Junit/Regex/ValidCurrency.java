import java.util.*;
import java.util.regex.*;

public class ValidCurrency {
    public static List<String> extractCurrencyValues(String text) {
        List<String> values = new ArrayList<>();
        Matcher m = Pattern.compile("\\$?\\d+\\.\\d{2}").matcher(text);
        while (m.find()) {
            values.add(m.group());
        }
        return values;
    }

    public static void main(String[] args) {
        System.out.println(extractCurrencyValues("Price is $45.99 and discount 10.50"));
    }
}
