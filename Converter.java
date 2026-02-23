/*
* The purpose of this file is to convert an
* prefix expression to a postfix expression.
*/

/**
 * Converter.java
 * High-performance Prefix to Postfix conversion.
 */
public class Converter {

    public String prefixToPostfix(String prefix) {
        StackExpressions stack = new StackExpressions();
        
        // Safety: If the line is empty, skip it
        if (prefix == null || prefix.trim().isEmpty()) {
            return "";
        }

        // STEP 1: Get the characters in REVERSE order
        // This is the secret to converting Prefix iteratively.
        char[] chars = prefix.toCharArray();
        
        // STEP 2: Process from the end of the string to the beginning
        for (int i = chars.length - 1; i >= 0; i--) {
            char c = chars[i];

            // Ignore spaces - crucial for line 6
            if (Character.isWhitespace(c)) {
                continue;
            }

            if (isOperator(c)) {
                // When we hit an operator, we need the last two operands we saw
                String op1 = stack.pop();
                String op2 = stack.pop();

                // ERROR CHECK: If we don't have 2 operands, the prefix is wrong
                if (op1 == null || op2 == null) {
                    return "Error: Invalid Prefix Format (Missing operands for " + c + ")";
                }

                // CONCATENATE: Left Operand + Right Operand + Operator
                // Note: op1 was the most recent thing pushed (the one closest to the operator)
                String combined = op1 + op2 + c;
                stack.push(combined);
            } else {
                // If it's a letter or number, it's an operand. Push it.
                stack.push(String.valueOf(c));
            }
        }

        // STEP 3: The result is the final item on the stack
        String result = stack.pop();

        // If something is still in the stack, there were too many letters
        if (!stack.isEmpty()) {
            return "Error: Invalid Prefix (Too many operands)";
        }

        return result;
    }

    private boolean isOperator(char c) {
        // Includes the special $ and ^ exponent operators found in your input
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '$' || c == '^';
    }
}