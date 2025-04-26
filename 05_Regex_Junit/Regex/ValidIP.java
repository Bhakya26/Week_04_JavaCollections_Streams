import java.util.regex.*;


public class ValidIP {
    public static boolean isValidIPAddress(String ip) {
        return Pattern.matches("^(25[0-5]|2[0-4]\\d|1?\\d{1,2})(\\.(25[0-5]|2[0-4]\\d|1?\\d{1,2})){3}$", ip);
    }

    public static void main(String[] args) {
        System.out.println(isValidIPAddress("192.168.1.1")); // true
    }
}