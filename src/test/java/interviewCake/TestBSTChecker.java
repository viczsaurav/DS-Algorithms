package interviewCake;

import interviewCake.BinaryTreeNode;
import org.junit.jupiter.api.Test;

import static interviewCake.BSTChecker.isBinarySearchTree;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestBSTChecker {

	// tests

	@Test
	public void validFullTreeTest() {
		final BinaryTreeNode root = new BinaryTreeNode(50);
		final BinaryTreeNode a = root.insertLeft(30);
		a.insertLeft(10);
		a.insertRight(40);
		final BinaryTreeNode b = root.insertRight(70);
		b.insertLeft(60);
		b.insertRight(80);
		final boolean result = isBinarySearchTree(root);
		assertTrue(result);
	}

	/**
	 *                  50
	 *               30    80
	 *             20  60 70 90
	 */
	@Test
	public void bothSubtreesValidTest() {
		final BinaryTreeNode root = new BinaryTreeNode(50);
		final BinaryTreeNode a = root.insertLeft(30);
		a.insertLeft(20);
		a.insertRight(60);
		final BinaryTreeNode b = root.insertRight(80);
		b.insertLeft(70);
		b.insertRight(90);
		final boolean result = isBinarySearchTree(root);
		assertFalse(result);
	}

	@Test
	public void descendingLinkedListTest() {
		final BinaryTreeNode root = new BinaryTreeNode(50);
		root.insertLeft(40).insertLeft(30).insertLeft(20).insertLeft(10);
		final boolean result = isBinarySearchTree(root);
		assertTrue(result);
	}

	@Test
	public void outOfOrderLinkedListTest() {
		final BinaryTreeNode root = new BinaryTreeNode(50);
		root.insertRight(70).insertRight(60).insertRight(80);
		final boolean result = isBinarySearchTree(root);
		assertFalse(result);
	}

	@Test
	public void oneNodeTreeTest() {
		final BinaryTreeNode root = new BinaryTreeNode(50);
		final boolean result = isBinarySearchTree(root);
		assertTrue(result);
	}
}
