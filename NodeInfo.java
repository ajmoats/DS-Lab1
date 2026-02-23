/*
* The purpose of this file is to define a link in a 
* linked structure to build a stack.
*/

public class NodeInfo {
    private String info; // The information stored in the node
    private NodeInfo next; // Reference to the next node in the stack

    // Constructor to initialize the node with information
    public NodeInfo(String info) {
        this.info = info;
        this.next = null; // Sets beginning of the stack to null
    }

    // Getter for the information stored in the node
    public String getInfo() {
        return info;
    }

    // Getter for the next node reference
    public NodeInfo getNext() {
        return next;
    }

    // Setter for the next node reference
    public void setNext(NodeInfo next) {
        this.next = next;
    }
}