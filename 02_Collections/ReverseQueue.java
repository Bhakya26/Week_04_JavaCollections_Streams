import java.util.*;
public class ReverseQueue {
	public static Queue<Integer> reverse(Queue<Integer> list){
		Stack<Integer> stack=new Stack<>();
		while(!list.isEmpty()) {
			stack.push(list.remove());
		}
		while(!stack.isEmpty()) {
			list.add(stack.pop());
		}
		return list;
	}
	public static void main(String[] args) {
		Queue<Integer> queue=new LinkedList<>();
		queue.add(10);
		queue.add(20);
		queue.add(30);
		System.out.println(queue);
		Queue<Integer> result=reverse(queue);
		System.out.println(result);
		
	}

}
