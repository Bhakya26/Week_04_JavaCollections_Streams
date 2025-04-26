import java.util.*;

public class MaxValueKey {
    public static String findMaxKey(Map<String, Integer> map) {
        String maxKey = null;
        int maxValue = Integer.MIN_VALUE;

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                maxKey = entry.getKey();
            }
        }

        return maxKey;
    }

    public static void main(String[] args) {
        Map<String, Integer> data = new HashMap<>();
        data.put("A", 10);
        data.put("B", 20);
        data.put("C", 15);

        String result = findMaxKey(data);
        System.out.println("Key with max value: " + result);  // Output: B
    }
}
