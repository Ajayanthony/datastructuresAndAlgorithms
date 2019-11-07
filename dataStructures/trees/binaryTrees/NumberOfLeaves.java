package trees.binaryTrees;

import java.util.LinkedList;

/**
 * Give an algorithm for finding the number of leaves in the binary tree without
 * using recursion.
 */
public class NumberOfLeaves {

    public static int getNumberOfLeaves(Node root) {
        LinkedList<Node> queue = new LinkedList<Node>();
        int count = 0;
        queue.push(root);

        while (!queue.isEmpty()) {
            Node temp = queue.pop();
            if (temp != null) {
                if (temp.left == null && temp.right == null)
                    count++;

                if (temp.left != null)
                    queue.push(temp.left);
                if (temp.right != null)
                    queue.push(temp.right);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        Node left = new Node(2);
        Node right = new Node(3);
        root.left = left;
        root.right = right;

        System.out.println("Num of Leaves: " + getNumberOfLeaves(root));

    }
}
