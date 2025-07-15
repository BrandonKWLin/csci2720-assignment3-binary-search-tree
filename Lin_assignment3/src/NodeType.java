package cs2720;

/**
 * Generic tree node used in the Binary Search Tree.
 *
 * @param <T> the type of data stored in the node
 */
public class NodeType<T extends Comparable<T>> {

    public T info;
    public NodeType<T> left;
    public NodeType<T> right;

    /**
     * Default constructor initializes an empty node.
     */
    public NodeType() {
        this.info = null;
        this.left = null;
        this.right = null;
    }

    /**
     * Constructs a node with a given value.
     *
     * @param info the data to store in the node
     */
    public NodeType(T info) {
        this.info = info;
        this.left = null;
        this.right = null;
    }
}
