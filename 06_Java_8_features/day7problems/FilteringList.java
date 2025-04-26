package day7problems;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class FilteringList {
	public static void main(String[] args) {
		List<String> names=Arrays.asList("Bhakya","Tinbeer","stephen","Alan","andrea");
		List<String> filterednames=names.stream().filter(name -> !name.startsWith("A"))
                .collect(Collectors.toList());
		 System.out.println("Filtered list (excluding names starting with 'A'):");
	        filterednames.forEach(System.out::println);
		
	}

}
