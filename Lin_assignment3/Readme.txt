Caspar Primke ctp78300@uga.edu (811269434)

Compile commands:
    javac -d bin src/NodeType.java
    javac -cp bin -d bin src/BinarySearchTree.java
    javac -cp bin -d bin src/BinarySearchTreeDriver.java

Run commands:
    java -cp bin cs2720/BinarySearchTreeDriver <file-name>

    just replace <file-name> with whatever file is called, assuiming the file
    name is int-input.txt, the command would be:

    java -cp bin cs2720/BinarySearchTreeDriver int-input.txt

getSingleParent function:

     public void getSingleParent(NodeType<T> tree) {
        if (tree != null) {
            getSingleParent(tree.left);
            if (tree.left == null ^ tree.right == null) {
                System.out.print(tree.info + " ");
            } // if
            getSingleParent(tree.right);
        } // if
     } // getSingleParent


     This function uses recursion to call upon each of the nodes in this tree,
     checking to see if they are single parents. It will call the node, first check to make sure
     it isnt null, then call the left branch of that node to print out the parents in-order.
     when checking to see if it should print, it makes sure that it has one child that is present
     and one that is null, then it prints the node's info. Then it makes the call on the right branch.
     This function goes through every node in the tree. So with a tree of n nodes,
     this function will run n times, making it O(n).

     The recurrence relation of this function came out T(n) = 2T(n/2) + O(1).
     With our master theorem we can break this down to O(n^{log_{b}a}) = O(n^{log_{2}2}) = O(n)

getNumLeafNodes function:

    public int getNumLeafNodes(NodeType<T> tree) {
        if (tree == null) {
            return 0;
        } else if (tree.right == null && tree.left == null) {
            return 1;
        } else {
            return getNumLeafNodes(tree.right) + getNumLeafNodes(tree.left);
        } // else
    } // getNumLeafNodes

    This function uses recursion to call upon each of the nodes in this tree,
    checking to see if they are leaf nodes. It will call the node, first check to make sure
    it isnt null. It will then check if it has no children, which if not, it will return a 1. If it does have
    children, it will call the function again on the left and right child. It then returns an integer of how many
    leaf nodes there are. It goes through every node in the tree, so with a tree of n nodes,
    this function will run n times, making it O(n).

    The recurrence relation of this function is similar to the last, being T(n) = 2T(n/2) + O(1).
    With this, our master theorem comes out to being O(n^{log_{b}a}) = O(n^{log_{2}2}) = O(n)

getCousins function:

    public void getCousins(T item) {
        int level = level(item);

        printLevel(root, item, level);
    } // getCousins

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

    This function uses two other functions to help it operate. It has one that finds the level, which goes through and finds
    the specific node wanting to find cousins of. That function runs at O(logn). Then there is the print level function which
    prints the level except the given node and any siblings. It is recursive and checks to see if the node is on the correct level,
    if not, it then makes sure none of it's children are the node we are finding cousins for. If that isnt the case, then it calls
    the function for each of its children. This function runs through every node in the tree, making it O(n). Thus, our main getCousin
    function is O(n).

    Our recurrence relation looks something similar to the others, T(n) = 2T(n/2) + O(1)
    Using our master theorem we can get the answer to be O(n^{log_{b}a}) = O(n^{log_{2}2}) = O(n)

    All of these have the same relation because of the posibility that in a balanced tree, they all run through every single node
    in the tree with n nodes.
