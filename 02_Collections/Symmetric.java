import java.util.*;
public class Symmetric {
	public static Set<Integer> symmetry(Set<Integer> s1,Set<Integer> s2){
		Set<Integer> a=new HashSet<>();
		Set<Integer> result=new HashSet<>();
		for(Integer i:s1) {
		if(!a.contains(i)) {
			a.add(null);
			result.add(i);
		}else {
			result.remove(i);
		}
	}
		
		for(Integer i:s2) {
		if(!a.contains(i)) {
			a.add(null);
			result.add(i);
		}else {
			result.remove(i);
		}
	}
		return result;
	}
		
	public static void main(String[] args) {
		Set<Integer> s1=new HashSet<>(Arrays.asList(1,2,3));
		Set<Integer> s2=new HashSet<>(Arrays.asList(3,4,5));
		Set<Integer> result=symmetry(s1,s2);
		System.out.println(result);
	}

}
