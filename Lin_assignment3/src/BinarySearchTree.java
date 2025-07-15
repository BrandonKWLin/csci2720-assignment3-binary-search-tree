package cs2720;

import cs2720.NodeType;

/**
   Doubly Linked List class with all implemented methods.
 */
public class BinarySearchTree<T extends Comparable<T>> {

    private NodeType<T> root;

    /**
       Makes a new Binary Search Tree.
    */
    public BinarySearchTree() {
    } // BinarySearchTree

    /**
       Retrieves the root.
       @return returns a the root of the tree.
     */
    public NodeType<T> getRoot() {
        return root;
    } // print

    /**
       Inserts an item into the tree according to its value.
       @param item the new item being inserted.
    */
    public void insert(T item) {
        NodeType<T> node = new NodeType<T>();
        node.info = item;
        NodeType<T> loc = root;
        NodeType<T> pred = null;

        if (root == null) {
            root = node;
        } else {
            while (loc != null) {
                if (item.compareTo(loc.info) > 0) {
                    pred = loc;
                    loc = loc.right;
                } else if (item.compareTo(loc.info) < 0) {
                    pred = loc;
                    loc = loc.left;
                } else if (item.compareTo(loc.info) == 0) {
                    throw new IllegalStateException("Item already exists");
                } // else
            } // while
            if (item.compareTo(pred.info) > 0) {
                pred.right = node;
            } else if (item.compareTo(pred.info) < 0) {
                pred.left = node;
            } // else
        } // else
    } // insert

    /**
       Deletes the node in the tree that contains an item equal to the
       item parameter.
       @param item the item to be removed.
       @param tree the root of the tree.
       @return the node that is to be deleted.
    */
    public NodeType<T> delete(NodeType<T> tree, T item) {
        if (tree == null) {
            System.out.println("Item not present");
            return tree;
        } // if
        if (item.compareTo(tree.info) < 0) {
            tree.left = delete(tree.left,item);
        } else if (item.compareTo(tree.info) > 0) {
            tree.right = delete(tree.right,item);
        } else {
            if (tree.left == null) {
                return tree.right;
            } // if
            if (tree.right == null) {
                return tree.left;
            } // if

            NodeType<T> succ = getSuccessor(tree);
            tree.info = succ.info;
            tree.right = delete(tree.right, succ.info);

        } // else
        return tree;
    } // delete

    /**
      Finds the proper successor for when a node has two children.
      @param loc the node that we start at.
      @return the node that we are using as our successor.
     */
    public NodeType<T> getSuccessor(NodeType<T> loc) {
        loc = loc.right;
        while (loc != null && loc.left != null) {
            loc = loc.left;
        }
        return loc;
    } //getSuccessor

    /**
       Prints the tree in order.
       @param tree is the tree that is being printed.
     */
    public void inOrder(NodeType<T> tree) {
        if (tree != null) {
            inOrder(tree.left);
            System.out.print(tree.info + " ");
            inOrder(tree.right);
        } // else
    } // inOrder

    /**
       Finds out whether or not the item given exists.
       @param item the item to be found
       @return true or false depending on existence
     */
    public boolean retrieve(T item) {
        NodeType<T> loc = root;
        NodeType<T> pred = null;

        if (root == null) {
            return false;
        } else {
            while (loc != null) {
                if (item.compareTo(loc.info) > 0) {
                    pred = loc;
                    loc = loc.right;
                } else if (item.compareTo(loc.info) < 0) {
                    pred = loc;
                    loc = loc.left;
                } else if (item.compareTo(loc.info) == 0) {
                    return true;
                } // else
            } // while
            return false;
        } // else
    } // retrieve

    /**
       Finds the number of leaf nodes in the tree.
       @param tree the root of the tree
       @return the number of leaf nodes
     */
    public int getNumLeafNodes(NodeType<T> tree) {
        if (tree == null) {
            return 0;
        } else if (tree.right == null && tree.left == null) {
            return 1;
        } else {
            return getNumLeafNodes(tree.right) + getNumLeafNodes(tree.left);
        } // else
    } // getNumLeafNodes

    /**
       Finds the single parent nodes in the tree.
       @param tree the root of the tree
    */
    public void getSingleParent(NodeType<T> tree) {
        if (tree != null) {
            getSingleParent(tree.left);
            if (tree.left == null ^ tree.right == null) {
                System.out.print(tree.info + " ");
            } // if
            getSingleParent(tree.right);
        } // if
    } // getSingleParent

    /**
       Finds the cousin nodes in the tree of the given node.
       @param item the item wanting to find cousins of
    */
    public void getCousins(T item) {
        int level = level(item);

        printLevel(root, item, level);
    } // getCousins

    /**
       Prints a specific level besides given node and siblings.
       @param tree the root of the tree
       @param item the item wanting to find cousins of
       @param level the level we want to print
    */
    public void printLevel(NodeType<T> tree, T item, int level) {
        if (tree != null) {
            if (level == 0 && item.compareTo(tree.info) != 0) {
                System.out.print(tree.info + " ");
            } else if (tree.left != null && tree.right != null) {
                if (item.compareTo(tree.left.info) != 0 && item.compareTo(tree.right.info) != 0) {
                    printLevel(tree.left,item,level - 1);
                    printLevel(tree.right,item,level - 1);
                } // if
            } else if (tree.left != null) {
                if (item.compareTo(tree.left.info) != 0) {
                    printLevel(tree.left,item,level - 1);
                } // if
            } else if (tree.right != null) {
                if (item.compareTo(tree.right.info) != 0) {
                    printLevel(tree.right,item,level - 1);
                } // if
            } // if
        }  // if
    } // PrintLevel

    /**
       Finds the level of the node.
       @param item the root of the tree
       @return an integer of what level
    */
    public int level(T item) {
        int level = 0;
        NodeType<T> loc = root;

        while (loc != null) {
            if (item.compareTo(loc.info) > 0) {
                loc = loc.right;
                level++;
            } else if (item.compareTo(loc.info) < 0) {
                loc = loc.left;
                level++;
            } else if (item.compareTo(loc.info) == 0) {
                return level;
            } // else
        } // while
        return level;
    } // level



} // BinarySearchTree
