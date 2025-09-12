// Name: Jose Flores
// Date: 9/5/2025
// Assignment: M5 Programming
/* Purpose: This program reads words from a
            file and shows all the unique words in 
            alphabetical order and reverse alphabetical order.*/


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class WordProcessor {

    private static final String FILE_NAME = "collection_of_words.txt";

    public static Set<String> getUniqueWords(String filename) throws IOException {
        String content = Files.readString(Paths.get(filename));
        String[] words = content.toLowerCase().replaceAll("[^a-z\\s]", "").split("\\s+");
        return new TreeSet<>(Arrays.asList(words));
    }

    public static void displayWords(Set<String> words) {
        System.out.println("Ascending Order:");
        words.forEach(word -> System.out.print(word + " "));
        System.out.println();

        System.out.println("Descending Order:");
        List<String> descending = new ArrayList<>(words);
        Collections.reverse(descending);
        descending.forEach(word -> System.out.print(word + " "));
        System.out.println();
    }

    public static void test() throws IOException {
        Set<String> uniqueWords = getUniqueWords(FILE_NAME);

        Set<String> expected = new TreeSet<>(Arrays.asList(
            "apple", "banana", "grape", "lemon", "mango", "orange", "pear"
        ));

        if (!uniqueWords.equals(expected)) {
            System.err.println("Test failed!");
            System.err.println("Expected: " + expected);
            System.err.println("Got: " + uniqueWords);
        } else {
            System.out.println("Test passed!");
            displayWords(uniqueWords);
        }
    }

    public static void main(String[] args) {
        try {
            test();
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}