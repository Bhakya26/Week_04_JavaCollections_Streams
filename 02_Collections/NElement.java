import java.util.*;

public class NElement {

    public static String findNthFromEnd(LinkedList<String> list, int n) {
        int first = 0;
        int second = 0;

      
        while (first < n) {
            if (first >= list.size()) {
                throw new IllegalArgumentException("List is shorter than " + n + " elements");
            }
            first++;
        }

      
        while (first < list.size()) {
            first++;
            second++;
        }

        return list.get(second);
    }

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>(Arrays.asList("A", "B", "C", "D", "E"));
        String result = findNthFromEnd(list, 2);
        System.out.println(result); 
    }
}

