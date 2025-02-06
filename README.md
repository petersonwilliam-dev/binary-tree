#AVLTree Class Documentation

##Overview

The AVLTree class implements an AVL tree, a self-balancing binary search tree. The AVL Tree ensures that the height difference between the left and right subtrees of any node is at most 1, providing efficiency in insertion, deletion, and search operations.

##Constructor

```java
public AVLTree()
```
Initializes an empty AVL tree.

##Methods

###Insertion
```java
public Node insert(int data)
```
Inserts a new node with the specified value into the tree.

- Parameters:
  - data: Integer value to be inserted.
- Returns:
  - The inserted node.
- Behavior:
  - The new node is positioned according to binary search tree rules.
  - After insertion, the tree's balance is checked and adjusted if necessary.

##Deletion
```java
public void remove(Node node)
```
Removes a node from the AVL tree.

- Parameters:
  - node: The node to be removed.

- Behavior:

  - If the node has a single child, it is replaced by that child.
  - If the node has two children, its in-order successor is used as a replacement.
  - After removal, the tree is rebalanced.

##Search
```java
public Node searchNode(int data)
```
Searches for a node with the specified value in the AVL tree.

- ###Parameters:

  - data: Value to be searched.

- ###Returns:
  - The corresponding node or null if the value is not found.

##Minimum Value Search
```java
public Node min(Node node)
```
Finds the node with the smallest value in the given subtree.

- ###Parameters:

  - node: Reference node.

- ###Returns:
  - The node with the smallest value in the subtree.

##Maximum Value Search
```java
public Node max(Node node)
```
Finds the node with the largest value in the given subtree.

- ###Parameters:
  - node: Reference node.

- ###Returns:
  - The node with the largest value in the subtree.

##Predecessor and Successor
```java
public Node predecessor(Node node)
public Node successor(Node node)
```
Returns the in-order predecessor or successor of a node.

- ###Parameters:
  - node: Reference node.

- ###Returns:
  - The predecessor (largest node smaller than the current one) or successor (smallest node larger than the current one), respectively.

##Balancing
```java
public void balance(Node node)
```
Ensures that the tree remains balanced after insertions or deletions.

- ###Parameters:
  - node: The reference node to start balancing.

- ###Behavior:
  -If a node is unbalanced, single or double rotations are applied as needed.

##Rotations
```java
public void rotateLeft(Node node)
public void rotateRight(Node node)
```
Performs left or right rotation on an unbalanced node.

- ###Parameters:
  - node: The node where the rotation is applied.

- ##Behavior:
  - Rotations help maintain the balance of the AVL tree.

##Balance Factor
```java
public int getBalanceFactor(Node node)
```
Calculates the balance factor of a node.

- ###Parameters:
  - node: The node to calculate the balance factor for.

- ###Returns:
  - The balance factor of the node.

##Tree Height
```java
public int lenghtTree(Node node)
```
Computes the height of the subtree from a given node.

- ###Parameters:
  - node: The reference node.

- ###Returns:
  - The height of the subtree.

##Tree Traversals
```java
public void inOrder(Node node)
public void preOrder(Node node)
public void posOrder(Node node)
public void reverseOrder(Node node)
```
Traverse the AVL tree in different orders.

- ###Parameters:
  - node: Reference node for traversal start.

- ###Output:

  - inOrder(Node node): Prints values in ascending order.
  
  - preOrder(Node node): Prints values in pre-order.
  
  - posOrder(Node node): Prints values in post-order.
  
  - reverseOrder(Node node): Prints values in descending order.

##Getters and Setters
```java
public Node getRoot()
public void setRoot(Node root)
```
Gets or sets the root of the AVL tree.

- ###Returns:

  - getRoot(): Returns the root of the AVL tree.
  - setRoot(Node root): Sets a new root node for the AVL tree.

##Final Considerations

The AVL Tree implementation follows the principles of a self-balancing binary search tree. The methods ensure efficiency in insertion, deletion, and search operations while maintaining automatic balancing through appropriate rotations.
