import java.util.*;
public class Subset {
	public static boolean findSubset(Set<Integer> set1,Set<Integer> set2){
		if(set1.containsAll(set2)) {
			return true;
		}else {
			return false;
		}
	}
	public static void main(String[] args) {
		Set<Integer> set1=new HashSet<>(Arrays.asList(1,2,3,4));
		Set<Integer> set2=new HashSet<>(Arrays.asList(2,3));
		boolean result=findSubset(set1,set2);
		System.out.println(result);
	}

}
