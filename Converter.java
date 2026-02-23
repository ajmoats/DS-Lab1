/*
* The purpose of this file is to convert an
* infix expression to a postfix expression.
*/

public class Converter {
    // Method to convert an infix expression to a postfix expression
    public String infixToPostfix(String infix) {
        StackExpressions stack = new StackExpressions(); // Create a stack to hold operators
        StringBuilder postfix = new StringBuilder(); // StringBuilder to build the postfix expression

        for (char c : infix.toCharArray()) { // Iterate through each character in the infix expression
            if (Character.isLetterOrDigit(c)) { // If the character is an operand (letter or digit)
                postfix.append(c); // Append it directly to the postfix expression
            } else if (c == '(') { // If the character is '(', push it onto the stack
                stack.push(String.valueOf(c));
            } else if (c == ')') { // If the character is ')', pop from the stack until '(' is found
                while (!stack.isEmpty() && !stack.peek().equals("(")) {
                    postfix.append(stack.pop()); // Append popped operators to the postfix expression
                }
                stack.pop(); // Pop the '(' from the stack
            } else { // If the character is an operator
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek().charAt(0))) {
                    postfix.append(stack.pop()); // Pop operators with higher or equal precedence and append to postfix
                }
                stack.push(String.valueOf(c)); // Push the current operator onto the stack
            }
        }

        while (!stack.isEmpty()) { // Pop any remaining operators from the stack and append to postfix
            postfix.append(stack.pop());
        }

        return postfix.toString(); // Return the final postfix expression as a string
    }

    // Helper method to determine the precedence of operators
    private int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1; // Lowest precedence for addition and subtraction
            case '*':
            case '/':
                return 2; // Higher precedence for multiplication and division
            default:
                return -1; // Return -1 for non-operator characters
        }
    }
}