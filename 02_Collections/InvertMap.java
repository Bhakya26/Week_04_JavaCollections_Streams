import java.util.*;

public class InvertMap {
    public static <K, V> Map<V, List<K>> invert(Map<K, V> inputMap) {
        Map<V, List<K>> inverted = new HashMap<>();

        for (Map.Entry<K, V> entry : inputMap.entrySet()) {
            V value = entry.getValue();
            K key = entry.getKey();

            inverted.computeIfAbsent(value, k -> new ArrayList<>()).add(key);
        }

        return inverted;
    }

    public static void main(String[] args) {
        Map<String, Integer> original = new HashMap<>();
        original.put("A", 1);
        original.put("B", 2);
        original.put("C", 1);

        Map<Integer, List<String>> inverted = invert(original);
        System.out.println(inverted);  // Output: {1=[A, C], 2=[B]}
    }
}

