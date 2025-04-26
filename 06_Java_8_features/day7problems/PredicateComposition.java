package day7problems;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateComposition{
    public static void main(String[] args) {
        
        List<String> words = Arrays.asList(
            "JavaProgramming", "Code", "Java", "Predicate", "FunctionalInterface", "StreamAPI"
        );

        Predicate<String> lengthGreaterThan5 = str -> str.length() > 5;

        Predicate<String> containsJava = str -> str.contains("Java");

        Predicate<String> combinedPredicate = lengthGreaterThan5.and(containsJava);

        List<String> filteredWords = words.stream()
            .filter(combinedPredicate)
            .collect(Collectors.toList());

        System.out.println("Filtered words (length > 5 and contains 'Java'):");
        filteredWords.forEach(System.out::println);
    }
}

