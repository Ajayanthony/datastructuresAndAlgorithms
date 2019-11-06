package dataStructures.trees.binaryTrees;

/**
 * Node class represents the nodes of a binary tree.
 *
 * Attributes are public for easier access in other programs.
 */
public class Node {
    public int value;
    public Node left;
    public Node right;

    public Node(int value) {
        this.value = value;
    }
}