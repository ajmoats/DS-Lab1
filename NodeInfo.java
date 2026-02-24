/**
 * NodeInfo.java
 * Represents a single node in a linked data structure.
 * Stores a String value and a reference to the next node.
 */

public class NodeInfo {
    private String info; // The information stored in the node
    private NodeInfo next; // Reference to the next node in the stack

    /**
     * Creates a new node with specified data.
     * @param info The string value to store.
     */
    public NodeInfo(String info) {
        this.info = info;
        this.next = null; // Sets beginning of the stack to null
    }

    /** @return The string information stored in this node. */
    public String getInfo() {
        return info;
    }

    /** @return The next node in the sequence. */
    public NodeInfo getNext() {
        return next;
    }

    /** @param next The node to be linked after this one. */
    public void setNext(NodeInfo next) {
        this.next = next;
    }
}