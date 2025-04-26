import java.util.*;

public class Frequency {
	public static Map<String,Integer> freq(List<String> list){
		Map<String,Integer> frequency=new HashMap<>();
		for(String item:list) {
		frequency.put(item, frequency.getOrDefault(item, 0) + 1);
}
		return frequency;
	}

	public static void main(String[] args) {
		List<String> input=Arrays.asList("Bhakya","tinbeer","gwen","Bhakya");
		System.out.println(input);
		Map<String,Integer> result=freq(input);
		System.out.println(result);
	}

}
