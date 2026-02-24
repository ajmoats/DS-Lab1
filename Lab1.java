import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

/*
* The purpose of this file is to serve as a link between each of the 
* helper files and the main method that is used to test the functionality of the helper files.
*/

public class Lab1 {
    /**
     * Entry point of the application.
     * @param args command line arguments (not used).
     */
    public static void main(String[] args) {
        Converter converter = new Converter();
        Scanner console = new Scanner(System.in); // This is for the file input
        Scanner fileReader = null;
        PrintWriter writer = null;

        try {
            // Get user input of file
            System.out.print("Enter the name of the input file (e.g., Required Input.txt): ");
            String fileName = console.nextLine();
            File inputFile = new File(fileName);
            
            // Validates the existence of an input file before proceeding
            if (!inputFile.exists()) {
                System.out.println("CRITICAL ERROR: File '" + fileName + "' not found.");
                System.out.println("Current directory: " + System.getProperty("user.dir"));
                return; // Stop the program here
            }

            fileReader = new Scanner(inputFile);
            writer = new PrintWriter(new File("Output.txt"));

            System.out.println("Reading '" + fileName + "' and writing results to 'Output.txt'...");

            int lineCount = 0;
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine().trim();
                if (line.isEmpty()) continue;

                // Converts and writes to the output file
                String result = converter.prefixToPostfix(line);
                writer.println("Prefix:  " + line);
                writer.println("Postfix: " + result);
                writer.println("---");
                lineCount++;
            }

            // Ensures all data is written to file
            writer.flush(); 
            System.out.println("Success! Processed " + lineCount + " lines.");

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            // Manual closing to prevent memory leaks
            if (fileReader != null) fileReader.close();
            if (writer != null) writer.close();
            if (console != null) console.close();
        }
    }
}