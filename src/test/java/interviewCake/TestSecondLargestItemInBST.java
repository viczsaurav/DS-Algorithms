package interviewCake;

import org.junit.jupiter.api.Test;

import static interviewCake.SecondLargestItemInBST.findSecondLargest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestSecondLargestItemInBST {

	// tests

	@Test
	public void findSecondLargestTest() {
		final BinaryTreeNode root = new BinaryTreeNode(50);
		final BinaryTreeNode a = root.insertLeft(30);
		a.insertLeft(10);
		a.insertRight(40);
		final BinaryTreeNode b = root.insertRight(70);
		b.insertLeft(60);
		b.insertRight(80);
		final int actual = findSecondLargest(root);
		final int expected = 70;
		assertEquals(expected, actual);
	}

	@Test
	public void largestHasLeftChildTest() {
		final BinaryTreeNode root = new BinaryTreeNode(50);
		final BinaryTreeNode a = root.insertLeft(30);
		a.insertLeft(10);
		a.insertRight(40);
		root.insertRight(70).insertLeft(60);
		final int actual = findSecondLargest(root);
		final int expected = 60;
		assertEquals(expected, actual);
	}

	@Test
	public void largestHasLeftSubtreeTest() {
		final BinaryTreeNode root = new BinaryTreeNode(50);
		final BinaryTreeNode a = root.insertLeft(30);
		a.insertLeft(10);
		a.insertRight(40);
		final BinaryTreeNode b = root.insertRight(70).insertLeft(60);
		b.insertLeft(55).insertRight(58);
		b.insertRight(65);
		final int actual = findSecondLargest(root);
		final int expected = 65;
		assertEquals(expected, actual);
	}

	@Test
	public void secondLargestIsRootNodeTest() {
		final BinaryTreeNode root = new BinaryTreeNode(50);
		final BinaryTreeNode a = root.insertLeft(30);
		a.insertLeft(10);
		a.insertRight(40);
		root.insertRight(70);
		final int actual = findSecondLargest(root);
		final int expected = 50;
		assertEquals(expected, actual);
	}

	@Test
	public void descendingLinkedListTest() {
		final BinaryTreeNode root = new BinaryTreeNode(50);
		root.insertLeft(40).insertLeft(30).insertLeft(20);
		final int actual = findSecondLargest(root);
		final int expected = 40;
		assertEquals(expected, actual);
	}

	@Test
	public void ascendingLinkedListTest() {
		final BinaryTreeNode root = new BinaryTreeNode(50);
		root.insertRight(60).insertRight(70).insertRight(80);
		final int actual = findSecondLargest(root);
		final int expected = 70;
		assertEquals(expected, actual);
	}

	@Test
	public void exceptionWithTreeThatHasOneNodeTest() {
		final BinaryTreeNode root = new BinaryTreeNode(50);
		assertThrows(Exception.class, ()-> {
			findSecondLargest(root);
		});
	}

	@Test
	public void exceptionWithEmptyTreeTest() {
		assertThrows(Exception.class, ()-> {
			findSecondLargest(null);
		});
	}

}
