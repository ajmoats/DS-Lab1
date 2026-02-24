/*
* The purpose of this file is to serve as a link between each of the 
* helper files and the main method that is used to test the functionality of the helper files.
*/

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class Lab1 {
    public static void main(String[] args) {
        Converter converter = new Converter();
        
        // Use standard objects so we can manually close them for safety
        Scanner reader = null;
        PrintWriter writer = null;

        try {
            File inputFile = new File("MyTests.txt");
            
            if (!inputFile.exists()) {
                System.out.println("CRITICAL ERROR: 'Required Input.txt' NOT FOUND!");
                System.out.println("Please put the file here: " + System.getProperty("user.dir"));
                return; // Stop the program here
            }

            reader = new Scanner(inputFile);
            writer = new PrintWriter(new File("Output.txt"));

            System.out.println("File found! Starting conversion...");

            int lineCount = 0;
            while (reader.hasNextLine()) {
                String line = reader.nextLine().trim();
                if (line.isEmpty()) continue;

                String result = converter.prefixToPostfix(line);
                writer.println("Prefix:  " + line);
                writer.println("Postfix: " + result);
                writer.println("---");
                lineCount++;
            }

            // IMPORTANT: The file is not saved until these lines run!
            writer.flush(); 
            System.out.println("Processed " + lineCount + " lines.");
            System.out.println("Success! 'Output.txt' has been saved to the folder.");

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Manual closing to force the OS to release the file
            if (reader != null) reader.close();
            if (writer != null) writer.close();
        }
    }
}