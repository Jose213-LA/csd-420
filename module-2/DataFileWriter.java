// Name: Jose Flores
// Date: 9/22/2025
// Assignment: M2
/* Purpose: This program makes random numbers and saves them in a file.*/

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class DataFileWriter {

    public static void main(String[] args) {
        Random rand = new Random();
        int[] intArray = new int[5];
        double[] doubleArray = new double[5];

        // Fill arrays with random values
        for (int i = 0; i < 5; i++) {
            intArray[i] = rand.nextInt(100); // random integer between 0-99
            doubleArray[i] = rand.nextDouble() * 100; // random double between 0.0-99.9
        }

        // Write to file (append mode)
        try (FileWriter writer = new FileWriter("JoseFlores_datafile.dat", true)) {
            writer.write("Integers: ");
            for (int value : intArray) {
                writer.write(value + " ");
            }
            writer.write("\nDoubles: ");
            for (double value : doubleArray) {
                writer.write(String.format("%.2f ", value));
            }
            writer.write("\n\n");
            System.out.println("Data written to file successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }
}