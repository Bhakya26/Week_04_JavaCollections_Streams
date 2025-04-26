import java.util.*;
public class ListReversing{
    public static ArrayList<Integer> Arraylist(ArrayList<Integer> list){
        ArrayList<Integer> reversed=new ArrayList<>();
        for(int i=list.size()-1;i>=0;i--){
            reversed.add(list.get(i));
        }
        return reversed;
    }
    public static LinkedList<Integer> Linkedlist(LinkedList<Integer> list){
        LinkedList<Integer> reversed=new LinkedList<>();
        for(int i=list.size()-1;i>=0;i--){
            reversed.add(list.get(i));
        }
        return reversed;
    }
    public static void main(String[] args){
        ArrayList<Integer> array=new ArrayList<>();
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        array.add(5);
        System.out.println("Original arraylist: "+array);
        ArrayList<Integer> Arraylist=Arraylist(array);
        System.out.println("Reversed arraylist: "+Arraylist);
        LinkedList<Integer> node=new LinkedList<>();
        for(int i=1;i<=5;i++){
        node.add(i);
     }
     System.out.println("Original linkedlist: "+node);
     LinkedList<Integer> Linkedlist = Linkedlist(node);
     System.out.println("reversed linked list: "+Linkedlist);
     
}
}