package trees.binaryTrees;

public class BinaryTreeUtils {

    public static int getHeight(Node root) {
        if (root == null)
            return 0;

        return Math.max(getHeight(root.left),
                getHeight(root.right)) + 1;
    }
}
