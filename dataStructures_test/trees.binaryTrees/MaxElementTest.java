package trees.binaryTrees;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxElementTest {

    private static Node root;

    @BeforeEach
    void setUp() {
        root = BinaryTreeTestUtils.getTestBinaryTree();
    }

    @Test
    void getMaxElementUsingRecursion() {
        assertEquals(7, MaxElement.getMaxElementUsingRecursion(root));
    }

    @Test
    void getMaxElementWithoutRecursion() {
        assertEquals(7, MaxElement.getMaxElementWithoutRecursion(root));
    }
}