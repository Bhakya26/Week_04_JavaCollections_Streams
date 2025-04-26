package day7problems;
import java.util.*;
class Person{
	private String name;
	private int age;
	private int salary;
	Person(String name,int age,int salary){
		this.name=name;
		this.age=age;
		this.salary=salary;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public int getSalary() {
		return salary;
	}
	public String toString() {
		return name+ " (Age: " + age + ", Salary: " + salary + ")";
	}
}
public class Sorting {
	public static void main(String[] args) {
		List<Person> object=new ArrayList<>();
		object.add(new Person("Bhakya",21,100000000));
		object.add(new Person("Tinbeer",20,500000));
		object.add(new Person("Johnsnow",25,900000));
		object.sort((p1,p2)-> Integer.compare(p1.getAge(),p2.getAge()));
		System.out.println("Sorted list of persons");
		object.forEach(System.out::println);
	}

}
