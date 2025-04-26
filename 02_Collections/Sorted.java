import java.util.*;
public class Sorted {
	public static List<Integer> sorting(Set<Integer> set){
		List<Integer> sorted=new ArrayList<>(set);
		Collections.sort(sorted);
		return sorted;
	}
	public static void main(String[] args) {
		Set<Integer> values=new HashSet<>(Arrays.asList(5,3,9,4,1));
		List<Integer> result=sorting(values);
		System.out.println(result);
		
	}

}
	