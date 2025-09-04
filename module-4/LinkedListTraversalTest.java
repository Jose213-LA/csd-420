// Name: Jose Flores
// Date: 8/30/2025
// Assignment: M4 Programming Assignment
/* Purpose: To compare the time it takes to traverse 
            a LinkedList using an iterator versus using 
            the get(index) method.*/

import java.util.LinkedList;
import java.util.Iterator;

public class LinkedListTraversalTest {

    public static void main(String[] args) {
        // Test with 50,000 elements
        System.out.println("=== Testing with 50,000 elements ===");
        testTraversal(50_000);

        // Test with 500,000 elements
        System.out.println("\n=== Testing with 500,000 elements ===");
        testTraversal(500_000);
    }

    // Method to test traversal times
    public static void testTraversal(int size) {
        LinkedList<Integer> list = new LinkedList<>();

        // Fill the LinkedList with integers
        for (int i = 0; i < size; i++) {
            list.add(i);
        }

        // Measure time using iterator
        long startTime = System.nanoTime();
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
        long endTime = System.nanoTime();
        long iteratorTime = endTime - startTime;
        System.out.println("Time using Iterator: " + iteratorTime / 1_000_000.0 + " ms");

        // Measure time using get(index)
        startTime = System.nanoTime();
        for (int i = 0; i < list.size(); i++) {
            list.get(i);
        }
        endTime = System.nanoTime();
        long getTime = endTime - startTime;
        System.out.println("Time using get(index): " + getTime / 1_000_000.0 + " ms");
    }
}