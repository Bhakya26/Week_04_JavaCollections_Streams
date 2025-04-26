import java.util.*;
import java.util.regex.*;

public class ValidCapitalWords{
    public static List<String> extractCapitalizedWords(String text) {
        List<String> words = new ArrayList<>();
        Matcher m = Pattern.compile("\\b[A-Z][a-z]*\\b").matcher(text);
        while (m.find()) {
            words.add(m.group());
        }
        return words;
    }

    public static void main(String[] args) {
        System.out.println(extractCapitalizedWords("The Eiffel Tower in Paris"));
    }
}