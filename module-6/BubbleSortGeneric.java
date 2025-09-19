// Name: Jose Flores
// Date: 9/12/2025
// Assignment:M6
/* Purpose: This program sorts arrays of any type using bubble sort,
            either in natural order or using a custom order.*/

import java.util.Comparator;

public class BubbleSortGeneric {

    // Method 1: Bubble Sort using Comparable (natural order)
    public static <E extends Comparable<E>> void bubbleSort(E[] list) {
        for (int i = 0; i < list.length - 1; i++) {
            for (int j = 0; j < list.length - 1 - i; j++) {
                if (list[j].compareTo(list[j + 1]) > 0) {
                    // Swap elements
                    E temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
            }
        }
    }

    // Method 2: Bubble Sort using Comparator (custom order)
    public static <E> void bubbleSort(E[] list, Comparator<? super E> comparator) {
        for (int i = 0; i < list.length - 1; i++) {
            for (int j = 0; j < list.length - 1 - i; j++) {
                if (comparator.compare(list[j], list[j + 1]) > 0) {
                    // Swap elements
                    E temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
            }
        }
    }

    // Helper method to print arrays
    public static <E> void printArray(E[] array) {
        System.out.print("Array: ");
        for (E item : array) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    // Main method for testing both sorting methods
    public static void main(String[] args) {

        // Test with Integer array using Comparable
        Integer[] intArray = {5, 3, 8, 1, 9, 2};
        System.out.println("Original Integer Array:");
        printArray(intArray);
        bubbleSort(intArray);
        System.out.println("Sorted with Comparable:");
        printArray(intArray);

        // Test with String array using Comparable
        String[] stringArray = {"Banana", "Apple", "Mango", "Cherry"};
        System.out.println("\nOriginal String Array:");
        printArray(stringArray);
        bubbleSort(stringArray);
        System.out.println("Sorted with Comparable:");
        printArray(stringArray);

        // Test with custom sorting (descending order for Integer)
        Integer[] intArray2 = {5, 3, 8, 1, 9, 2};
        System.out.println("\nOriginal Integer Array:");
        printArray(intArray2);
        bubbleSort(intArray2, (a, b) -> b - a); // Descending order
        System.out.println("Sorted with Comparator (Descending):");
        printArray(intArray2);
    }
}