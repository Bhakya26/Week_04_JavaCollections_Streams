package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListManagerTest {

    private ListManager manager;
    private List<Integer> testList;

    @BeforeEach
    void setUp() {
        manager = new ListManager();
        testList = new ArrayList<>();
    }

    @Test
    void testAddElement() {
        manager.addElement(testList, 10);
        assertTrue(testList.contains(10), "List should contain the added element.");
    }

    @Test
    void testRemoveElement() {
        testList.add(20);
        manager.removeElement(testList, 20);
        assertFalse(testList.contains(20), "List should not contain the removed element.");
    }

    @Test
    void testGetSize() {
        assertEquals(0, manager.getSize(testList));
        manager.addElement(testList, 5);
        manager.addElement(testList, 15);
        assertEquals(2, manager.getSize(testList), "Size should reflect number of elements in the list.");
    }
}
