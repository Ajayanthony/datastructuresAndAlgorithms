package trees.binaryTrees;

/**
 * Give an algorithm for finding the diameter of the binary tree. The diameter of a
 * tree (sometimes called the width) is the number of nodes on the longest path between two
 * leaves in the tree.
 */
public class TreeDiameter {

    public static int getTreeDiameter(Node root) {
        if (root == null)
            return 0;

        int leftDiameter = getTreeDiameter(root.left);
        int rightDiameter = getTreeDiameter(root.right);

        int rootDiameter = BinaryTreeUtils.getHeight(root.left) +
                BinaryTreeUtils.getHeight(root.right) + 1;
        int childDiameter = Math.max(leftDiameter, rightDiameter);

        return Math.max(rootDiameter, childDiameter);
    }
}
