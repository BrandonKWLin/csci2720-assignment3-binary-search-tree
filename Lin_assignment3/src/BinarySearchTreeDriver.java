package cs2720;

import cs2720.NodeType;
import cs2720.BinarySearchTree;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
   Binary Search Tree Driver.
 */
public class BinarySearchTreeDriver {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Scanner input;
        String type;
        String com;
        String inputS;
        Double inputD;
        int inputI;
        BinarySearchTree<String> listS = new BinarySearchTree<>();
        BinarySearchTree<Integer> listI = new BinarySearchTree<>();
        BinarySearchTree<Double> listD = new BinarySearchTree<>();

        System.out.print("Enter list type (i - int, d - double, s - string): ");

        while (true) {

            type = sc.next();

            if (type.equals("i") || type.equals("s") || type.equals("d")) {
                break;
            } else {
                System.out.print("Please enter a proper type (i - int, d - double, s - string): ");
            } // no proper command

        } // type of list : while

        try {
            File file = new File(args[0]);
            input = new Scanner(file);
            while (input.hasNext()) {
                try {
                    if (type.equals("s")) {
                        listS.insert(input.next());
                    } else if (type.equals("d")) {
                        listD.insert(input.nextDouble());
                    } else if (type.equals("i")) {
                        listI.insert(input.nextInt());
                    } // else if
                } catch (IllegalStateException e) {
                } // try catch
            } // while
            input.close();
        } catch (ArrayIndexOutOfBoundsException | IOException ioException) {
            System.err.println("Cannot open file or file not present.");
            System.exit(1);
        }

        System.out.println("Commands:");
        System.out.println("(i) - Insert Item"); // done
        System.out.println("(d) - Delete Item"); // done
        System.out.println("(p) - Print Tree"); // done
        System.out.println("(r) - Retrieve Item"); // done
        System.out.println("(l) - Count Leaf Nodes"); // done
        System.out.println("(s) - Find Single Parents"); // done
        System.out.println("(c) - Find Cousins"); // done
        System.out.println("(q) - Quit program" + "\n"); // done

        System.out.print("Enter a command: ");

        while (true) {

            com = sc.next();

            if (com.equals("i")) {
                if (type.equals("s")) {
                    System.out.print("In-order: ");
                    listS.inOrder(listS.getRoot());
                    System.out.println();
                    System.out.print("Enter a string to insert: ");
                    inputS = sc.next();
                    try {
                        listS.insert(inputS);
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                    } // try catch
                    System.out.print("In-order: ");
                    listS.inOrder(listS.getRoot());
                    System.out.println();
                } else if (type.equals("d")) {
                    System.out.print("In-order: ");
                    listD.inOrder(listD.getRoot());
                    System.out.println();
                    System.out.print("Enter a number to insert: ");
                    inputD = sc.nextDouble();
                    try {
                        listD.insert( inputD);
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                    } // try catch
                    System.out.print("In-order: ");
                    listD.inOrder(listD.getRoot());
                    System.out.println();
                } else if (type.equals("i")) {
                    System.out.print("In-order: ");
                    listI.inOrder(listI.getRoot());
                    System.out.println();
                    System.out.print("Enter a number to insert: ");
                    inputI = sc.nextInt();
                    try {
                        listI.insert(inputI);
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                    } // try catch
                    System.out.print("In-order: ");
                    listI.inOrder(listI.getRoot());
                    System.out.println();
                } // else
                System.out.print("Enter a command: ");
            } // if : command i : Insert Item

            else if (com.equals("d")) {
                if (type.equals("s")) {
                    System.out.print("In-order: ");
                    listS.inOrder(listS.getRoot());
                    System.out.println();
                    System.out.print("Enter a string to delete: ");
                    inputS = sc.next();
                    listS.delete(listS.getRoot(),inputS);
                    System.out.print("In-order: ");
                    listS.inOrder(listS.getRoot());
                    System.out.println();
                } else if (type.equals("d")) {
                    System.out.print("In-order: ");
                    listD.inOrder(listD.getRoot());
                    System.out.println();
                    System.out.print("Enter a number to delete: ");
                    inputD = sc.nextDouble();
                    listD.delete(listD.getRoot(),inputD);
                    System.out.print("In-order: ");
                    listD.inOrder(listD.getRoot());
                    System.out.println();
                } else if (type.equals("i")) {
                    System.out.print("In-order: ");
                    listI.inOrder(listI.getRoot());
                    System.out.println();
                    System.out.print("Enter a number to delete: ");
                    inputI = sc.nextInt();
                    listI.delete(listI.getRoot(),inputI);
                    System.out.print("In-order: ");
                    listI.inOrder(listI.getRoot());
                    System.out.println();
                } // else
                System.out.print("Enter a command: ");
            } // if : command d : Delete Item

            else if (com.equals("p")) {
                if (type.equals("s")) {
                    System.out.print("In-order: ");
                    listS.inOrder(listS.getRoot());
                    System.out.println();
                } else if (type.equals("d")) {
                    System.out.print("In-order: ");
                    listD.inOrder(listD.getRoot());
                    System.out.println();
                } else if (type.equals("i")) {
                    System.out.print("In-order: ");
                    listI.inOrder(listI.getRoot());
                    System.out.println();
                } // else if
                System.out.print("Enter a command: ");
            } // if : command p : Print tree

            else if (com.equals("r")) {
                if (type.equals("s")) {
                    System.out.print("In-order: ");
                    listS.inOrder(listS.getRoot());
                    System.out.println();
                    System.out.print("Enter a string to search: ");
                    inputS = sc.next();
                    if (listS.retrieve(inputS)) {
                        System.out.println("Item is present in the tree");
                    } else {
                        System.out.println("Item is not present in the tree");
                    } // else
                } else if (type.equals("d")) {
                    System.out.print("In-order: ");
                    listD.inOrder(listD.getRoot());
                    System.out.println();
                    System.out.print("Enter a number to search: ");
                    inputD = sc.nextDouble();
                    if (listD.retrieve(inputD)) {
                        System.out.println("Item is present in the tree");
                    } else {
                        System.out.println("Item is not present in the tree");
                    } // else
                } else if (type.equals("i")) {
                    System.out.print("In-order: ");
                    listI.inOrder(listI.getRoot());
                    System.out.println();
                    System.out.print("Enter a number to search: ");
                    inputI = sc.nextInt();
                    if (listI.retrieve(inputI)) {
                        System.out.println("Item is present in the tree");
                    } else {
                        System.out.println("Item is not present in the tree");
                    } // else
                } // else if
                System.out.print("Enter a command: ");
            } // if : command r : Retrieve Item

            else if (com.equals("l")) {
                if (type.equals("s")) {
                    System.out.println("The number of leaf nodes are "
                        + listS.getNumLeafNodes(listS.getRoot()));
                } else if (type.equals("d")) {
                    System.out.println("The number of leaf nodes are "
                        + listD.getNumLeafNodes(listD.getRoot()));
                } else if (type.equals("i")) {
                    System.out.println("The number of leaf nodes are "
                        + listI.getNumLeafNodes(listI.getRoot()));
                } // else if
                System.out.print("Enter a command: ");
            } // if : command l : Count Leaf Nodes

            else if (com.equals("s")) {
                if (type.equals("s")) {
                    System.out.print("Single Parents: ");
                    listS.getSingleParent(listS.getRoot());
                    System.out.println();
                } else if (type.equals("d")) {
                    System.out.print("Single Parents: ");
                    listD.getSingleParent(listD.getRoot());
                    System.out.println();
                } else if (type.equals("i")) {
                    System.out.print("Single Parents: ");
                    listI.getSingleParent(listI.getRoot());
                    System.out.println();
                } // else
                System.out.print("Enter a command: ");
            } // if : command s : Find Single Parents

            else if (com.equals("c")) {
                if (type.equals("s")) {
                    System.out.print("In-order: ");
                    listS.inOrder(listS.getRoot());
                    System.out.println();
                    System.out.print("Enter a string: ");
                    inputS = sc.next();
                    System.out.print(inputS + " cousins: ");
                    listS.getCousins(inputS);
                    System.out.println();
                } else if (type.equals("d")) {
                    System.out.print("In-order: ");
                    listD.inOrder(listD.getRoot());
                    System.out.println();
                    System.out.print("Enter a number: ");
                    inputD = sc.nextDouble();
                    System.out.print(inputD + " cousins: ");
                    listD.getCousins(inputD);
                    System.out.println();
                } else if (type.equals("i")) {
                    System.out.print("In-order: ");
                    listI.inOrder(listI.getRoot());
                    System.out.println();
                    System.out.print("Enter a number: ");
                    inputI = sc.nextInt();
                    System.out.print(inputI + " cousins: ");
                    listI.getCousins(inputI);
                    System.out.println();
                } // else if
                System.out.print("Enter a command: ");
            } // if : command c : Find Cousins

            else if (com.equals("q")) {
                System.out.println("Exiting the program...");
                break;
            } // if : command q : quit : done

            else {
                System.out.print("Invalid command try again: " );
            } // else : invalid command : done

        } // command loop : while

    } // main
} // BinarySearchTreeDriver
