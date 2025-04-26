import java.util.*;
import java.util.regex.*;

public class CensorBadWords {
    public static String censorBadWords(String text, List<String> badWords) {
        for (String word : badWords) {
            text = Pattern.compile(Pattern.quote(word), Pattern.CASE_INSENSITIVE).matcher(text).replaceAll("****");
        }
        return text;
    }

    public static void main(String[] args) {
        List<String> badWords = Arrays.asList("damn", "stupid");
        System.out.println(censorBadWords("This is a damn stupid test", badWords));
    }
}
