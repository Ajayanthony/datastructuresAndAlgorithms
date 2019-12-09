package trees.binaryTrees;

public class MorrisTraversal {

    /* Function to traverse a binary tree without recursion and
      without stack. From GeeksForGeeks. */
    public static void startMorrisTraversal(Node root) {
        Node current, pre;

        if (root == null)
            return;

        current = root;
        while (current != null) {
            if (current.left == null) {
                System.out.print(current.value + " ");
                current = current.right;
            } else {
                /* Find the inorder predecessor of current */
                pre = current.left;
                while (pre.right != null && pre.right != current)
                    pre = pre.right;

                /* Make current as right child of its inorder predecessor */
                if (pre.right == null) {
                    pre.right = current;
                    current = current.left;

                }
                /* Revert the changes made in the 'if' part to restore the
                    original tree i.e., fix the right child of predecessor*/
                else {
                    pre.right = null;
                    System.out.print(current.value + " ");
                    current = current.right;
                } /* End of if condition pre->right == NULL */

            } /* End of if condition current->left == NULL*/

        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        startMorrisTraversal(root);
    }
}
