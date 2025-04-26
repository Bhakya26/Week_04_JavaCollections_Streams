import java.util.*;
public class RotateList {
	public static List<Integer> rotate(List<Integer> list,int position){
		int size=list.size();
		position=position%size;
		List<Integer> rotated=new ArrayList<>();
		rotated.addAll(list.subList(position,size));
		rotated.addAll(list.subList(0,position));
		return rotated;
	}
	public static void main(String[] args) {
		List<Integer> input=Arrays.asList(1,2,3,4,5,6,7);
		System.out.println(input);
		List<Integer> result=rotate(input,2);
		System.out.println(result);
	}

}
