/*
* The purpose of this file is to define a link in a 
* linked structure to build a stack.
*/

/*
 * The purpose of this file is to define a custom Stack data structure.
 * It uses a linked structure (NodeInfo) to manage elements in a 
 * Last-In, First-Out (LIFO) manner without using library functions.
 */
public class StackExpressions {
    private NodeInfo top; // Reference to the top of the stack

    // Constructor to initialize an empty stack
    public StackExpressions() {
        this.top = null; 
    }

    // Method to check if the stack is empty
    public boolean isEmpty() {
        return top == null; 
    }

    // Method to push a new item onto the stack
    public void push(String info) {
        NodeInfo newNode = new NodeInfo(info); 
        newNode.setNext(top); 
        top = newNode; 
    }

    /* * Method to pop an item from the stack.
     * Returns null if the stack is empty to allow the Converter 
     * to handle the error gracefully without crashing.
     */
    public String pop() {
        if (isEmpty()) { 
            return null; 
        }
        String info = top.getInfo(); 
        top = top.getNext(); 
        return info; 
    }

    // Method to peek at the top item without removing it
    public String peek() {
        if (isEmpty()) { 
            return null;
        }
        return top.getInfo(); 
    }
}