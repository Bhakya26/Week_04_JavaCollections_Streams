import java.util.*;
import java.util.regex.*;

public class ValidRepeatingWord {
    public static Set<String> findRepeatingWords(String text) {
        Set<String> repeated = new HashSet<>();
        Matcher m = Pattern.compile("\\b(\\w+)\\b\\s+\\1\\b", Pattern.CASE_INSENSITIVE).matcher(text);
        while (m.find()) {
            repeated.add(m.group(1));
        }
        return repeated;
    }

    public static void main(String[] args) {
        System.out.println(findRepeatingWords("This is is a repeated repeated test"));
    }
}