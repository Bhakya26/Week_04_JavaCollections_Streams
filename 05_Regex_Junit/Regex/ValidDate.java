import java.util.*;
import java.util.regex.*;


public class ValidDate {
    public static List<String> extractDates(String text) {
        List<String> dates = new ArrayList<>();
        Matcher m = Pattern.compile("\\b\\d{2}/\\d{2}/\\d{4}\\b").matcher(text);
        while (m.find()) {
            dates.add(m.group());
        }
        return dates;
    }

    public static void main(String[] args) {
        System.out.println(extractDates("Dates: 12/05/2023, 15/08/2024"));
    }
}