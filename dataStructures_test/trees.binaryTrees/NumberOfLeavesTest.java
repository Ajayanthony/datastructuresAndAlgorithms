package trees.binaryTrees;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberOfLeavesTest {

    private static Node root;

    @BeforeEach
    void setUp() {
        root = BinaryTreeTestUtils.getTestBinaryTree();
    }

    @Test
    void getNumberOfLeaves() {
        assertEquals(4, NumberOfLeaves.getNumberOfLeaves(root));
    }
}
