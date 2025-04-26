

import java.util.*;

public class FrequencyMap {
    public static Map<String, Integer> countWords(String text) {
        Map<String, Integer> frequency = new HashMap<>();

        
        text = text.replaceAll("[^a-zA-Z ]", "").toLowerCase();

        String[] words = text.split("\\s+");

        for (String word : words) {
            if (word.isEmpty()) continue;
            frequency.put(word, frequency.getOrDefault(word, 0) + 1);
        }

        return frequency;
    }

    public static void main(String[] args) {
        String input = "Hello world, hello Java!";
        Map<String, Integer> result = countWords(input);
        System.out.println(result); 
        }
}
