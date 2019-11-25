package trees.bst;

import trees.binaryTrees.Node;

public class BinarySearchTree {

    /**
     * Give an algorithm to check whether the given binary tree is a BST or not.
     * <p>
     * O(n2) approach>>Compare root with min and max values of left and right subtrees recursively.
     */
    public static boolean isBinaryTreeBST(Node root) {
        if (root == null) return true;

        if ((root.left != null && getMaxElement(root.left).value > root.value)
                || (root.right != null && getMinElement(root.right).value < root.value)) {
            return false;
        }

        return isBinaryTreeBST(root.left) && isBinaryTreeBST(root.right);
    }

    /**
     * O(n) approach>> Set min and max values for comparision at each node.
     */
    public static boolean isBinaryTreeBST2(Node root) {
        return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static boolean isBSTUtil(Node root, int min, int max) {
        if (root == null) return true;

        return (root.value >= min && root.value <= max
                && isBSTUtil(root.left, min, root.value)
                && isBSTUtil(root.right, root.value, max));
    }


    private static Node getMinElement(Node node) {

        while (node.left != null) {
            node = node.left;
        }

        return node;
    }

    private static Node getMaxElement(Node node) {
        while (node.right != null) {
            node = node.right;
        }

        return node;
    }
}
