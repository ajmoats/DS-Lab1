/**
 * StackExpressions.java
 * A custom linked-list based stack implementation for managing Strings.
 * Follows Last-In-First-Out (LIFO) principles.
 */
public class StackExpressions {
    private NodeInfo top; // Reference to the top of the stack

    /**
     * Initializes an empty stack.
     */
    public StackExpressions() {
        this.top = null; 
    }

    /**
     * Checks if the stack contains any elements.
     * @return true if the stack is empty.
     */
    public boolean isEmpty() {
        return top == null; 
    }

    /**
     * Adds a new string to the top of the stack.
     * @param info The string data to be stored.
     */
    public void push(String info) {
        NodeInfo newNode = new NodeInfo(info); 
        newNode.setNext(top); 
        top = newNode; 
    }

    /**
     * Removes and returns the top element of the stack.
     * @return The top string, or null if the stack is empty.
     */
    public String pop() {
        if (isEmpty()) { 
            return null; 
        }
        String info = top.getInfo(); 
        top = top.getNext(); 
        return info; 
    }

    /**
     * Retrieves the top element without removing it.
     * @return The top string, or null if empty.
     */
    public String peek() {
        if (isEmpty()) { 
            return null;
        }
        return top.getInfo(); 
    }
}