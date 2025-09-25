// Name: Jose Flores
// Date: 9/20/2025
// Assignment: M8-Programming Assignment
// Purpose: This program uses three threads to print random letters, 
            numbers, and symbols to show how multithreading works in Java.

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class JoseThreeThreads {

    private static final int COUNT = 10000;

    public static void main(String[] args) {
        // Create the GUI
        JFrame frame = new JFrame("Three Threads Output");
        JTextArea textArea = new JTextArea(30, 100);
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.add(scrollPane);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // Create and start threads
        Thread letterThread = new Thread(new LetterGenerator(textArea));
        Thread numberThread = new Thread(new NumberGenerator(textArea));
        Thread symbolThread = new Thread(new SymbolGenerator(textArea));

        letterThread.start();
        numberThread.start();
        symbolThread.start();
    }

    // Thread for generating random letters
    static class LetterGenerator implements Runnable {
        private final JTextArea textArea;
        private final Random random = new Random();

        public LetterGenerator(JTextArea textArea) {
            this.textArea = textArea;
        }

        @Override
        public void run() {
            for (int i = 0; i < COUNT; i++) {
                char c = (char) (random.nextInt(26) + 'a');
                appendToTextArea(c);
            }
        }

        private void appendToTextArea(char c) {
            SwingUtilities.invokeLater(() -> textArea.append(c + ""));
        }
    }

    // Thread for generating random numbers
    static class NumberGenerator implements Runnable {
        private final JTextArea textArea;
        private final Random random = new Random();

        public NumberGenerator(JTextArea textArea) {
            this.textArea = textArea;
        }

        @Override
        public void run() {
            for (int i = 0; i < COUNT; i++) {
                char c = (char) (random.nextInt(10) + '0');
                appendToTextArea(c);
            }
        }

        private void appendToTextArea(char c) {
            SwingUtilities.invokeLater(() -> textArea.append(c + ""));
        }
    }

    // Thread for generating random symbols
    static class SymbolGenerator implements Runnable {
        private final JTextArea textArea;
        private final Random random = new Random();
        private final char[] symbols = {'!', '@', '#', '$', '%', '&', '*'};

        public SymbolGenerator(JTextArea textArea) {
            this.textArea = textArea;
        }

        @Override
        public void run() {
            for (int i = 0; i < COUNT; i++) {
                char c = symbols[random.nextInt(symbols.length)];
                appendToTextArea(c);
            }
        }

        private void appendToTextArea(char c) {
            SwingUtilities.invokeLater(() -> textArea.append(c + ""));
        }
    }
}