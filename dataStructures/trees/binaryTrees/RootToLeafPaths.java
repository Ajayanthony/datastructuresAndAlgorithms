package trees.binaryTrees;

import java.util.LinkedList;

/**
 * Given a binary tree, print out all its root-to-leaf paths.
 */
public class RootToLeafPaths {

    public static void printRootToLeafPaths(Node root) {
        LinkedList<Node> stack = new LinkedList<>();
        printLeafPath(root, stack);
    }

    private static void printLeafPath(Node node, LinkedList<Node> stack) {
        if (node == null)
            return;
        if (node.left != null || node.right != null) {
            stack.push(node);
            if (node.left != null)
                printLeafPath(node.left, stack);
            if (node.right != null)
                printLeafPath(node.right, stack);
            stack.pop();
        } else {
            stack.stream()
                    .forEach(n -> System.out.print(n.value + " -> "));
            System.out.println(node.value);
        }
    }
}
