package trees.binaryTrees;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckMirrorTreeTest {

    private static Node root;
    private static Node root2;

    @BeforeEach
    void setUp() {
        root = BinaryTreeTestUtils.getTestBinaryTree();
        root2 = new Node(1);
        root2.right = new Node(2);
        root2.left = new Node(3);
        root2.right.right = new Node(4);
        root2.right.left = new Node(5);
        root2.left.right = new Node(6);
        root2.left.left = new Node(7);
    }

    @Test
    void isMirrorTree() {
        assertTrue(CheckMirrorTree.isMirrorTree(null, null));
        assertTrue(CheckMirrorTree.isMirrorTree(root, root2));
    }
}