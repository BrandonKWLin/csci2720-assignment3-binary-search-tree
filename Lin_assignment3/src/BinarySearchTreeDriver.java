package cs2720;

import cs2720.NodeType;
import cs2720.BinarySearchTree;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Driver class to test the Binary Search Tree functionality.
 */
public class BinarySearchTreeDriver {

    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        String type = getTreeType(console);

        BinarySearchTree<String> treeStr = new BinarySearchTree<>();
        BinarySearchTree<Integer> treeInt = new BinarySearchTree<>();
        BinarySearchTree<Double> treeDouble = new BinarySearchTree<>();

        loadDataFromFile(args, type, treeStr, treeInt, treeDouble);

        printCommandMenu();

        while (true) {
            System.out.print("Enter a command: ");
            String command = console.next();

            if (command.equals("i")) {
                performInsert(console, type, treeStr, treeInt, treeDouble);
            } else if (command.equals("d")) {
                performDelete(console, type, treeStr, treeInt, treeDouble);
            } else if (command.equals("p")) {
                performPrint(type, treeStr, treeInt, treeDouble);
            } else if (command.equals("r")) {
                performRetrieve(console, type, treeStr, treeInt, treeDouble);
            } else if (command.equals("l")) {
                performLeafCount(type, treeStr, treeInt, treeDouble);
            } else if (command.equals("s")) {
                performSingleParents(type, treeStr, treeInt, treeDouble);
            } else if (command.equals("c")) {
                performCousins(console, type, treeStr, treeInt, treeDouble);
            } else if (command.equals("q")) {
                System.out.println("Exiting the program...");
                break;
            } else {
                System.out.println("Invalid command. Try again.");
            }
        }
    }

    private static String getTreeType(Scanner sc) {
        String type;
        do {
            System.out.print("Enter list type (i - int, d - double, s - string): ");
            type = sc.next();
        } while (!type.equals("i") && !type.equals("d") && !type.equals("s"));
        return type;
    }

    private static void loadDataFromFile(
            String[] args,
            String type,
            BinarySearchTree<String> treeStr,
            BinarySearchTree<Integer> treeInt,
            BinarySearchTree<Double> treeDouble) {

        try {
            File file = new File(args[0]);
            Scanner fileInput = new Scanner(file);

            while (fileInput.hasNext()) {
                try {
                    switch (type) {
                        case "s" -> treeStr.insert(fileInput.next());
                        case "i" -> treeInt.insert(fileInput.nextInt());
                        case "d" -> treeDouble.insert(fileInput.nextDouble());
                    }
                } catch (IllegalStateException ignored) {
                    // Duplicate values are ignored
                }
            }
            fileInput.close();
        } catch (ArrayIndexOutOfBoundsException | IOException e) {
            System.err.println("Cannot open file or file not present.");
            System.exit(1);
        }
    }

    private static void printCommandMenu() {
        System.out.println("""
            Commands:
            (i) - Insert Item
            (d) - Delete Item
            (p) - Print Tree
            (r) - Retrieve Item
            (l) - Count Leaf Nodes
            (s) - Find Single Parents
            (c) - Find Cousins
            (q) - Quit program
        """);
    }

    private static void performInsert(
            Scanner sc,
            String type,
            BinarySearchTree<String> treeStr,
            BinarySearchTree<Integer> treeInt,
            BinarySearchTree<Double> treeDouble) {

        switch (type) {
            case "s" -> {
                treeStr.inOrder(treeStr.getRoot());
                System.out.println();
                System.out.print("Enter a string to insert: ");
                String input = sc.next();
                try {
                    treeStr.insert(input);
                } catch (IllegalStateException e) {
                    System.out.println(e.getMessage());
                }
                treeStr.inOrder(treeStr.getRoot());
                System.out.println();
            }
            case "i" -> {
                treeInt.inOrder(treeInt.getRoot());
                System.out.println();
                System.out.print("Enter an integer to insert: ");
                int val = sc.nextInt();
                try {
                    treeInt.insert(val);
                } catch (IllegalStateException e) {
                    System.out.println(e.getMessage());
                }
                treeInt.inOrder(treeInt.getRoot());
                System.out.println();
            }
            case "d" -> {
                treeDouble.inOrder(treeDouble.getRoot());
                System.out.println();
                System.out.print("Enter a double to insert: ");
                double val = sc.nextDouble();
                try {
                    treeDouble.insert(val);
                } catch (IllegalStateException e) {
                    System.out.println(e.getMessage());
                }
                treeDouble.inOrder(treeDouble.getRoot());
                System.out.println();
            }
        }
    }

    private static void performDelete(
            Scanner sc,
            String type,
            BinarySearchTree<String> treeStr,
            BinarySearchTree<Integer> treeInt,
            BinarySearchTree<Double> treeDouble) {

        switch (type) {
            case "s" -> {
                treeStr.inOrder(treeStr.getRoot());
                System.out.println();
                System.out.print("Enter a string to delete: ");
                String input = sc.next();
                treeStr.delete(treeStr.getRoot(), input);
                treeStr.inOrder(treeStr.getRoot());
                System.out.println();
            }
            case "i" -> {
                treeInt.inOrder(treeInt.getRoot());
                System.out.println();
                System.out.print("Enter an integer to delete: ");
                int val = sc.nextInt();
                treeInt.delete(treeInt.getRoot(), val);
                treeInt.inOrder(treeInt.getRoot());
                System.out.println();
            }
            case "d" -> {
                treeDouble.inOrder(treeDouble.getRoot());
                System.out.println();
                System.out.print("Enter a double to delete: ");
                double val = sc.nextDouble();
                treeDouble.delete(treeDouble.getRoot(), val);
                treeDouble.inOrder(treeDouble.getRoot());
                System.out.println();
            }
        }
    }

    private static void performPrint(
            String type,
            BinarySearchTree<String> treeStr,
            BinarySearchTree<Integer> treeInt,
            BinarySearchTree<Double> treeDouble) {

        switch (type) {
            case "s" -> {
                System.out.print("In-order: ");
                treeStr.inOrder(treeStr.getRoot());
                System.out.println();
            }
            case "i" -> {
                System.out.print("In-order: ");
                treeInt.inOrder(treeInt.getRoot());
                System.out.println();
            }
            case "d" -> {
                System.out.print("In-order: ");
                treeDouble.inOrder(treeDouble.getRoot());
                System.out.println();
            }
        }
    }

    private static void performRetrieve(
            Scanner sc,
            String type,
            BinarySearchTree<String> treeStr,
            BinarySearchTree<Integer> treeInt,
            BinarySearchTree<Double> treeDouble) {

        switch (type) {
            case "s" -> {
                treeStr.inOrder(treeStr.getRoot());
                System.out.println();
                System.out.print("Enter a string to search: ");
                String input = sc.next();
                System.out.println(treeStr.retrieve(input) ?
                        "Item is present in the tree" :
                        "Item is not present in the tree");
            }
            case "i" -> {
                treeInt.inOrder(treeInt.getRoot());
                System.out.println();
                System.out.print("Enter an integer to search: ");
                int val = sc.nextInt();
                System.out.println(treeInt.retrieve(val) ?
                        "Item is present in the tree" :
                        "Item is not present in the tree");
            }
            case "d" -> {
                treeDouble.inOrder(treeDouble.getRoot());
                System.out.println();
                System.out.print("Enter a double to search: ");
                double val = sc.nextDouble();
                System.out.println(treeDouble.retrieve(val) ?
                        "Item is present in the tree" :
                        "Item is not present in the tree");
            }
        }
    }

    private static void performLeafCount(
            String type,
            BinarySearchTree<String> treeStr,
            BinarySearchTree<Integer> treeInt,
            BinarySearchTree<Double> treeDouble) {

        int leaves = switch (type) {
            case "s" -> treeStr.getNumLeafNodes(treeStr.getRoot());
            case "i" -> treeInt.getNumLeafNodes(treeInt.getRoot());
            case "d" -> treeDouble.getNumLeafNodes(treeDouble.getRoot());
            default -> 0;
        };

        System.out.println("The number of leaf nodes is " + leaves);
    }

    private static void performSingleParents(
            String type,
            BinarySearchTree<String> treeStr,
            BinarySearchTree<Integer> treeInt,
            BinarySearchTree<Double> treeDouble) {

        System.out.print("Single Parents: ");
        switch (type) {
            case "s" -> treeStr.getSingleParent(treeStr.getRoot());
            case "i" -> treeInt.getSingleParent(treeInt.getRoot());
            case "d" -> treeDouble.getSingleParent(treeDouble.getRoot());
        }
        System.out.println();
    }

    private static void performCousins(
            Scanner sc,
            String type,
            BinarySearchTree<String> treeStr,
            BinarySearchTree<Integer> treeInt,
            BinarySearchTree<Double> treeDouble) {

        switch (type) {
            case "s" -> {
                treeStr.inOrder(treeStr.getRoot());
                System.out.println();
                System.out.print("Enter a string: ");
                String input = sc.next();
                System.out.print(input + " cousins: ");
                treeStr.getCousins(input);
                System.out.println();
            }
            case "i" -> {
                treeInt.inOrder(treeInt.getRoot());
                System.out.println();
                System.out.print("Enter an integer: ");
                int val = sc.nextInt();
                System.out.print(val + " cousins: ");
                treeInt.getCousins(val);
                System.out.println();
            }
            case "d" -> {
                treeDouble.inOrder(treeDouble.getRoot());
                System.out.println();
                System.out.print("Enter a double: ");
                double val = sc.nextDouble();
                System.out.print(val + " cousins: ");
                treeDouble.getCousins(val);
                System.out.println();
            }
        }
    }
}
