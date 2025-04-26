package test;

import java.util.List;

public class ListManager {

    public void addElement(List<Integer> list, int element) {
        list.add(element);
    }

    public void removeElement(List<Integer> list, int element) {
        list.remove(Integer.valueOf(element)); // Avoid index-based remove
    }

    public int getSize(List<Integer> list) {
        return list.size();
    }
}
