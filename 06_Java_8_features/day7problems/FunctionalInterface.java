package day7problems;

interface adding{
	int sum(int a,int b);
}

public class FunctionalInterface {
	public static void main(String[] args) {
		adding add=(a,b)-> a+b;
		int result=add.sum(2,3);
		System.out.println(result);
	}

}
