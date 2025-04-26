import java.util.*;
import java.util.regex.*;

public class ValidLang {
    public static List<String> extractProgrammingLanguages(String text) {
        List<String> langs = new ArrayList<>();
        Matcher m = Pattern.compile("\\b(Java|Python|JavaScript|Go)\\b").matcher(text);
        while (m.find()) {
            langs.add(m.group());
        }
        return langs;
    }

    public static void main(String[] args) {
        System.out.println(extractProgrammingLanguages("I know Java and Python"));
    }
}