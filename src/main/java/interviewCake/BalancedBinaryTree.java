package interviewCake;

public class BalancedBinaryTree {
	/**
	 * Write a function to see if a binary tree ↴ is "superbalanced" (a new tree property we just made up).
	 *
	 * A tree is "superbalanced" if the difference between the depths of any two leaf nodes is no greater than one.
	 */

	public static class BinaryTreeNode {

		public int value;
		public BinaryTreeNode left;
		public BinaryTreeNode right;

		public BinaryTreeNode(int value) {
			this.value = value;
		}

		public BinaryTreeNode insertLeft(int leftValue) {
			this.left = new BinaryTreeNode(leftValue);
			return this.left;
		}

		public BinaryTreeNode insertRight(int rightValue) {
			this.right = new BinaryTreeNode(rightValue);
			return this.right;
		}
	}


	public static boolean isBalanced(BinaryTreeNode treeRoot) {

		// determine if the tree is superbalanced


		return false;
	}
}
