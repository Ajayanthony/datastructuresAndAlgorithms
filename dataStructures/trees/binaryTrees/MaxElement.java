package trees.binaryTrees;

import java.util.LinkedList;

/**
 * Give an algorithm for finding maximum element in binary tree.
 */
public class MaxElement {

    /**
     * Recursive approach of checking left and right subtree.
     * @param root Root node.
     * @return Max int value.
     */
    public static int getMaxElementUsingRecursion(Node root) {
        if (root == null) return Integer.MIN_VALUE;
        int leftMax = getMaxElementUsingRecursion(root.left);
        int rightMax = getMaxElementUsingRecursion(root.right);

        if (leftMax > rightMax && leftMax > root.value)
            return leftMax;

        if (rightMax > leftMax && rightMax > root.value)
            return rightMax;

        return root.value;
    }

    /**
     * DFS approach to check the max val in the tree.
     *
     * @param root Root of tree.
     * @return Max int val.
     */
    public static int getMaxElementWithoutRecursion(Node root) {
        LinkedList<Node> queue = new LinkedList<Node>();
        int maxVal = Integer.MIN_VALUE;
        queue.add(root);

        while (!queue.isEmpty()) {
            Node temp = queue.pop();
            if (temp != null) {
                if (maxVal < temp.value) {
                    maxVal = temp.value;
                }
                queue.push(temp.left);
                queue.push(temp.right);
            }
        }
        return maxVal;
    }
}