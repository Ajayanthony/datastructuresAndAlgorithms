package trees.binaryTrees;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PathSumTest {
    private static Node root;

    @BeforeEach
    void setUp() {
        root = BinaryTreeTestUtils.getTestBinaryTree();
    }

    @Test
    void hasPathWithSum() {
        assertTrue(PathSum.hasPathWithSum(root, 7));
        assertFalse(PathSum.hasPathWithSum(root, 12));
    }

    @Test
    void getShortestPathWithSum() {

    }
}