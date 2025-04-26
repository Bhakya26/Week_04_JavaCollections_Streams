import java.util.*;
import java.util.regex.*;

public class ValidLinks {
    public static List<String> extractLinks(String text) {
        List<String> links = new ArrayList<>();
        Matcher m = Pattern.compile("https?://\\S+").matcher(text);
        while (m.find()) {
            links.add(m.group());
        }
        return links;
    }

    public static void main(String[] args) {
        System.out.println(extractLinks("Visit https://www.google.com"));
    }
}