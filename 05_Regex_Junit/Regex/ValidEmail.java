import java.util.*;
import java.util.regex.*;

public class ValidEmail {
    public static List<String> extractEmails(String text) {
        List<String> emails = new ArrayList<>();
        Matcher m = Pattern.compile("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}").matcher(text);
        while (m.find()) {
            emails.add(m.group());
        }
        return emails;
    }

    public static void main(String[] args) {
        System.out.println(extractEmails("Contact support@example.com and info@company.org"));
    }
}
