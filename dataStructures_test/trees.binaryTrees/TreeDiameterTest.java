package trees.binaryTrees;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TreeDiameterTest {

    private static Node root;

    @BeforeEach
    void setUp() {
        root = BinaryTreeTestUtils.getTestBinaryTree();
    }

    @Test
    void getTreeDiameter() {
        assertEquals(5, TreeDiameter.getTreeDiameter(root));
    }
}