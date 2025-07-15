package cs2720;

import cs2720.NodeType;

/**
 * BinarySearchTree class implementing typical BST operations.
 */
public class BinarySearchTree<T extends Comparable<T>> {

    private NodeType<T> root;

    /** Constructs an empty Binary Search Tree. */
    public BinarySearchTree() {
        // No initialization needed for empty tree
    }

    /** Returns the root node of the tree. */
    public NodeType<T> getRoot() {
        return root;
    }

    /** 
     * Inserts a new item into the BST.
     * @param item the element to insert
     */
    public void insert(T item) {
        NodeType<T> newNode = new NodeType<>();
        newNode.info = item;

        if (root == null) {
            root = newNode;
            return;
        }

        NodeType<T> current = root;
        NodeType<T> parent = null;

        while (current != null) {
            parent = current;
            int cmp = item.compareTo(current.info);
            if (cmp > 0) {
                current = current.right;
            } else if (cmp < 0) {
                current = current.left;
            } else {
                throw new IllegalStateException("Item already exists in tree.");
            }
        }

        if (item.compareTo(parent.info) > 0) {
            parent.right = newNode;
        } else {
            parent.left = newNode;
        }
    }

    /**
     * Deletes a node containing the specified item from the tree.
     * @param tree the current root
     * @param item the item to delete
     * @return the new root after deletion
     */
    public NodeType<T> delete(NodeType<T> tree, T item) {
        if (tree == null) {
            System.out.println("Item not present");
            return null;
        }

        int cmp = item.compareTo(tree.info);
        if (cmp < 0) {
            tree.left = delete(tree.left, item);
        } else if (cmp > 0) {
            tree.right = delete(tree.right, item);
        } else {
            if (tree.left == null) return tree.right;
            if (tree.right == null) return tree.left;

            NodeType<T> successor = getSuccessor(tree);
            tree.info = successor.info;
            tree.right = delete(tree.right, successor.info);
        }
        return tree;
    }

    /**
     * Finds the in-order successor for a node with two children.
     * @param node the node whose successor is sought
     * @return the successor node
     */
    public NodeType<T> getSuccessor(NodeType<T> node) {
        NodeType<T> curr = node.right;
        while (curr != null && curr.left != null) {
            curr = curr.left;
        }
        return curr;
    }

    /**
     * Performs in-order traversal to print the tree contents.
     * @param node the current node
     */
    public void inOrder(NodeType<T> node) {
        if (node == null) return;
        inOrder(node.left);
        System.out.print(node.info + " ");
        inOrder(node.right);
    }

    /**
     * Checks whether an item exists in the BST.
     * @param item the item to find
     * @return true if found; false otherwise
     */
    public boolean retrieve(T item) {
        NodeType<T> current = root;

        while (current != null) {
            int cmp = item.compareTo(current.info);
            if (cmp > 0) {
                current = current.right;
            } else if (cmp < 0) {
                current = current.left;
            } else {
                return true;
            }
        }
        return false;
    }

    /**
     * Counts the number of leaf nodes in the tree.
     * @param node the current node
     * @return the count of leaf nodes
     */
    public int getNumLeafNodes(NodeType<T> node) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) return 1;
        return getNumLeafNodes(node.left) + getNumLeafNodes(node.right);
    }

    /**
     * Prints all nodes that have exactly one child.
     * @param node the current node
     */
    public void getSingleParent(NodeType<T> node) {
        if (node == null) return;

        getSingleParent(node.left);

        boolean hasSingleChild = (node.left == null) ^ (node.right == null);
        if (hasSingleChild) {
            System.out.print(node.info + " ");
        }

        getSingleParent(node.right);
    }

    /**
     * Prints cousin nodes of a specified item.
     * @param item the item whose cousins are sought
     */
    public void getCousins(T item) {
        int targetLevel = findLevel(item);
        printCousinsAtLevel(root, item, targetLevel);
    }

    /**
     * Prints all nodes at a given level that are not siblings of the given item.
     * @param node the current node
     * @param item the item whose cousins are sought
     * @param level the target level
     */
    public void printCousinsAtLevel(NodeType<T> node, T item, int level) {
        if (node == null) return;

        if (level == 0 && !item.equals(node.info)) {
            System.out.print(node.info + " ");
        } else if (node.left != null && node.right != null) {
            if (!item.equals(node.left.info) && !item.equals(node.right.info)) {
                printCousinsAtLevel(node.left, item, level - 1);
                printCousinsAtLevel(node.right, item, level - 1);
            }
        } else if (node.left != null) {
            if (!item.equals(node.left.info)) {
                printCousinsAtLevel(node.left, item, level - 1);
            }
        } else if (node.right != null) {
            if (!item.equals(node.right.info)) {
                printCousinsAtLevel(node.right, item, level - 1);
            }
        }
    }

    /**
     * Determines the level (depth) of the node containing the item.
     * @param item the item to find
     * @return the level (root is level 0)
     */
    public int findLevel(T item) {
        int level = 0;
        NodeType<T> current = root;

        while (current != null) {
            int cmp = item.compareTo(current.info);
            if (cmp > 0) {
                current = current.right;
                level++;
            } else if (cmp < 0) {
                current = current.left;
                level++;
            } else {
                return level;
            }
        }
        return level;
    }
}
