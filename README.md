- ⚠️ **DISCLAIMER:** Do NOT copy or submit this project as your official assignment. Doing so is an academic violation and may result in disciplinary action. This README is provided for learning and personal reference only.
- ⚠️ This is for employment purposes, to be included in the projects section of my resume.
  
# CSCI 2720 - Assignment 3

**Developer:** Brandon Lin

---

## Overview

Java-based command-line application implementing a **generic binary search tree (BST)**. The program supports:

- Insertion and deletion of nodes (no duplicates allowed)
- In-order tree traversal
- Searching/retrieving items
- Counting leaf nodes
- Finding single-parent nodes
- Finding cousins of a given node

Supports three data types: **int, double, and string**, selected dynamically via user input. Reads initial data from text files and provides an interactive CLI for managing the tree.

---

## Compile Instructions

Run the following commands from the root of the project:

```bash
javac -d bin src/NodeType.java
javac -cp bin -d bin src/BinarySearchTree.java
javac -cp bin -d bin src/BinarySearchTreeDriver.java
```

---

## Run Instructions

Execute the program with:

```bash
java -cp bin cs2720/BinarySearchTreeDriver <file-name>
```

Replace `<file-name>` with your input file name (e.g. `int-input.txt`):

```bash
java -cp bin cs2720/BinarySearchTreeDriver int-input.txt
```

---

## Technologies Used

- Java
- Command-Line Interface (CLI)
- Generics
- Data Structures: Binary Search Trees

---

## Author

Brandon Lin  
