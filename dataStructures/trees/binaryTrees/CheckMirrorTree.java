package trees.binaryTrees;

/**
 * Given two trees, give an algorithm for checking whether they are mirrors of
 * each other.
 */
public class CheckMirrorTree {

    public static boolean isMirrorTree(Node root1, Node root2) {
        if (root1 == null && root2 == null)
            return true;
        if (root1 == null || root2 == null)
            return false;

        if (root1.value != root2.value)
            return false;

        return isMirrorTree(root1.left, root2.right)
                && isMirrorTree(root1.right, root2.left);
    }
}
