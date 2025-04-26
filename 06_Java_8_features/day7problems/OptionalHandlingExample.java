package day7problems;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class OptionalHandlingExample {
    public static void main(String[] args) {
        List<Integer> numbers1 = Arrays.asList(3, 5, 2, 9, 4);
        List<Integer> numbers2 = Collections.emptyList();

        Optional<Integer> max1 = findMax(numbers1);
        max1.ifPresentOrElse(
            max -> System.out.println("Max of numbers1: " + max),
            () -> System.out.println("numbers1 is empty")
        );

        Optional<Integer> max2 = findMax(numbers2);
        max2.ifPresentOrElse(
            max -> System.out.println("Max of numbers2: " + max),
            () -> System.out.println("numbers2 is empty")
        );
    }

    
    public static Optional<Integer> findMax(List<Integer> list) {
        return list.stream()
                   .max(Integer::compareTo);
    }
}

