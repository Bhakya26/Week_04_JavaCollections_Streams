package day7problems;
import java.util.*;

public class SumOfSquares {
	public static void main(String[] args) {
		List<Integer> list=Arrays.asList(1,2,3,4);
		int sum=list.stream().filter(n-> n%2==0).map(n-> n*n).reduce(0,(a,b)->a+b);
		System.out.println("Sum of squares of even numbers: "+sum);
		
		
	}

}
