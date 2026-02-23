/*
* The purpose of this file is to define a link in a 
* linked structure to build a stack.
*/

public class StackExpressions {
    private NodeInfo top; // Reference to the top of the stack

    // Constructor to initialize an empty stack
    public StackExpressions() {
        this.top = null; // Sets the top of the stack to null
    }

    // Method to check if the stack is empty
    public boolean isEmpty() {
        return top == null; // Returns true if the stack is empty
    }

    // Method to push a new item onto the stack
    public void push(String info) {
        NodeInfo newNode = new NodeInfo(info); // Create a new node with the given information
        newNode.setNext(top); // Set the next reference of the new node to the current top
        top = newNode; // Update the top reference to the new node
    }

    // Method to pop an item from the stack
    public String pop() {
        if (isEmpty()) { // Check if the stack is empty before popping
            throw new RuntimeException("Stack is empty"); // Throw an exception if trying to pop from an empty stack
        }
        String info = top.getInfo(); // Get the information from the top node
        top = top.getNext(); // Update the top reference to the next node in the stack
        return info; // Return the popped information
    }

    // Method to peek at the top item of the stack without removing it
    public String peek() {
        if (isEmpty()) { // Check if the stack is empty before peeking
            throw new RuntimeException("Stack is empty"); // Throw an exception if trying to peek at an empty stack
        }
        return top.getInfo(); // Return the information from the top node without modifying the stack
    }
}