// Name: Jose Flores
// Date: 9/22/2025
// Assignment: M2
/* Purpose: This program opens the file and shows the numbers.*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DataFileReader {

    public static void main(String[] args) {
        File file = new File("JoseFlores_datafile.dat");

        // Read and display file content
        try (Scanner scanner = new Scanner(file)) {
            System.out.println("Reading data from file:\n");

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }

        } catch (FileNotFoundException e) {
            System.out.println("The file does not exist.");
            e.printStackTrace();
        }
    }
}