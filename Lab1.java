/*
* The purpose of this file is to serve as a link between each of the 
* helper files and the main method that is used to test the functionality of the helper files.
*/

public class Lab1 {
    public static void main(String[] args) {
        Converter converter = new Converter(); // Create an instance of the Converter class
        String infixExpression = "A+B*C"; // Define an infix expression to convert
        String postfixExpression = converter.infixToPostfix(infixExpression); // Convert the infix expression to postfix
        System.out.println("Infix Expression: " + infixExpression); // Print the original infix expression
        System.out.println("Postfix Expression: " + postfixExpression); // Print the resulting postfix expression
    }
}
