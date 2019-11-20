package trees.binaryTrees;

/**
 * Give an algorithm for checking the existence of path with given sum. That
 * means, given a sum, check whether there exists a path from root to any of the nodes.
 */
public class PathSum {

    public static boolean hasPathWithSum(Node root, int sum) {
        if (root == null && sum != 0)
            return false;

        int diff = sum - root.value;
        if (diff == 0) return true;

        return hasPathWithSum(root.left, diff) ||
                hasPathWithSum(root.right, diff);
    }

    //TODO
    public static boolean getShortestPathWithSum(Node root, int sum) {
        return false;
    }
}
