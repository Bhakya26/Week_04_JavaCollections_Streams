import java.util.*;
public class RemoveDuplicate {
	public static List<Integer> remove(List<Integer> list){
		Set<Integer> seen=new HashSet<>();
		List<Integer> removed=new ArrayList<>();
		for(Integer a:list) {
			if(!seen.contains(a)) {
				seen.add(a);
				removed.add(a);
				}
		}
		return removed;
	}
	public static void main(String[] args) {
		List<Integer> input=Arrays.asList(1,4,2,3,3,4,1,2);
		List<Integer> result=remove(input);
		System.out.println(result);
		
	}

}
