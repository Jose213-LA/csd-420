// Name: Jose Flores
// Date: 8/29/2025
// Assignment: M3 Programming Assignment
/* Purpose: To create a list of random numbers 
            and return a new list with all duplicates removed.*/

import java.util.ArrayList;
import java.util.Random;

public class RemoveDuplicatesTest {

    public static void main(String[] args) {
        // Create and fill the original ArrayList with 50 random integers (1–20)
        ArrayList<Integer> originalList = new ArrayList<>();
        Random rand = new Random();

        for (int i = 0; i < 50; i++) {
            originalList.add(rand.nextInt(20) + 1); // Generates 1 to 20
        }

        // Print the original list
        System.out.println("Original List (with duplicates):");
        System.out.println(originalList);

        // Call the removeDuplicates method
        ArrayList<Integer> uniqueList = removeDuplicates(originalList);

        // Print the list after removing duplicates
        System.out.println("\nList after removing duplicates:");
        System.out.println(uniqueList);
    }

    // Generic method to remove duplicates from an ArrayList
    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
        ArrayList<E> result = new ArrayList<>();
        for (E element : list) {
            if (!result.contains(element)) {
                result.add(element);
            }
        }
        return result;
    }
}