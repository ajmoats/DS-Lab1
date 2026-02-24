/**
 * Author: Alexis Moats
 * Converter.java
 * Contains the logic for converting Prefix expressions to Postfix.
 * Utilizes an iterative approach by processing the input string in reverse.
 */

public class Converter {
    /**
     * Converts a prefix expression string into a postfix expression string.
     * @param prefix The input prefix string (e.g., "+ AB").
     * @return The resulting postfix string (e.g., "AB+"), or an error message.
     */
    public String prefixToPostfix(String prefix) {
        StackExpressions stack = new StackExpressions();
        
        // Safety: If the line is empty, skip it
        if (prefix == null || prefix.trim().isEmpty()) {
            return "";
        }

        // Get the characters in REVERSE order
        char[] chars = prefix.toCharArray();
        
        // Process from the end of the string to the beginning
        for (int i = chars.length - 1; i >= 0; i--) {
            char c = chars[i];

            // Ignore spaces in expressions
            if (Character.isWhitespace(c)) {
                continue;
            }

            if (isOperator(c)) {
                // At operator, get the last two operands seen
                String op1 = stack.pop();
                String op2 = stack.pop();

                // ERROR CHECK: If we don't have 2 operands, the prefix is wrong
                if (op1 == null || op2 == null) {
                    return "Error: Invalid Prefix Format (Missing operands for " + c + ")";
                }

                // Put together the Expression: Left Operand + Right Operand + Operator
                // op1 was the most recent thing pushed (the one closest to the operator)
                String combined = op1 + op2 + c;
                stack.push(combined);
                } else if (Character.isLetterOrDigit(c)) {
                stack.push(String.valueOf(c));
                } else {
                return "Error: Invalid character '" + c + "'";
            }
        }

        String result = stack.pop();

        // ERROR CHECK: If something is still in the stack, there were too many letters
        if (!stack.isEmpty()) {
            return "Error: Invalid Prefix (Too many operands)";
        }

        return result;
    }

    /**
     * Determines if a character is a supported mathematical operator.
     * @param c The character to check.
     * @return true if character is +, -, *, /, $, or ^.
     */
    private boolean isOperator(char c) {
        // Includes the $ and ^ exponent operators
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '$' || c == '^';
    }
}