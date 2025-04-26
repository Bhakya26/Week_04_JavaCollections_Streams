import java.util.*;
public class Union {
	public static Set<Integer> unionSet(Set<Integer> s1,Set<Integer> s2){
		Set<Integer> union=new HashSet<>(s1);
		union.addAll(s2);
		return union;
		}
	public static Set<Integer> intersectionSet(Set<Integer> s1,Set<Integer> s2){
		Set<Integer> intersection=new HashSet<>(s1);
		intersection.retainAll(s2);
		return intersection;
	}
	public static void main(String[] args) {
		Set<Integer> s1=new HashSet<>(Arrays.asList(1,2,3));
		Set<Integer> s2=new HashSet<>(Arrays.asList(3,4,5));
		Set<Integer> union=unionSet(s1,s2);
		Set<Integer> intersection=intersectionSet(s1,s2);
		System.out.println("Union: "+union);
		System.out.println("Intersection: "+intersection);
	}

}
