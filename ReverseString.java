// imports
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

/**
 * This program reads lines from input.txt, reverses each line using
 * a recursive function, and writes the reversed lines to output.txt.
 *
 * @author Dylan Mutabazi
 * @version 1.0
 * @since 2025-December
 */
final class ReverseString {

    /**
     * Prevent instantiation of utility class.
     */
    private ReverseString() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Recursively reverses a string.
     *
     * @param str the string to reverse
     * @return the reversed string
     */

    public static String recReverse(final String str) {
        // Base case: if the string is empty, return an empty string
        if (str.length() == 0) {
            return "";
        }
        // return the last character + the reverse of the rest of the string
        return str.charAt(str.length() - 1)
        + recReverse(str.substring(0, str.length() - 1));
    }

    /**
     * Entrypoint of the program.
     *
     * @param args command-line arguments (unused)
     */
    public static void main(final String[] args) {

        // File handling with try-catch for exceptions
        try {
            // Create file and scanner objects to read from input.txt
            File file = new File("input.txt");
            Scanner scanner = new Scanner(file);
            FileWriter writer = new FileWriter("output.txt");

            // Read each line, calles function, and write to output.txt
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String reversedLine = recReverse(line);
                writer.write(reversedLine + System.lineSeparator());
            }

            // Close the scanner and writer
            scanner.close();
            writer.close();

            // Prints out crashes/errors that may occur.
        } catch (FileNotFoundException e) {
            System.out.println("input file was not found.");
        } catch (IOException e) {
            System.out.println("Enable to write to output file.");
        }
    }
}
