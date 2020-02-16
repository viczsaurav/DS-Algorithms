package interviewCake;

public class BSTChecker {

	/**
	 * Write a method to check that a binary tree ↴ is a valid binary search tree. ↴
	 *
	 * Properties to check for validity:
	 *  - 2 nodes
	 *  - val(node.left)< val(node) <= val(node.right)
	 */

	public static boolean isBinarySearchTreeBug(BinaryTreeNode root) {

		/**
		 * Doesnt work for something like:
		 *                  50
		 *               30   80
		 *             20 60 70 90
		 *
		 *  Have to keep track of min and max(range) for each
		 */
		if (root==null) return false;

		if(root.left !=null) {
			if(root.value<root.left.value)  return false;
			return isBinarySearchTreeBug(root.left);
		}

		if(root.right !=null) {
			if(root.value>root.right.value)  return false;
			return isBinarySearchTreeBug(root.right);
		}
		return true;
	}


	public static boolean isBinarySearchTree(BinaryTreeNode root) {
//		return checkNodeValue(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
		return checkInOrder(root);
	}

	public static boolean checkNodeValue(BinaryTreeNode node, int lower, int upper) {

		if (node==null) return true;
		if(node.value<= lower || node.value > upper)	return false;
		return checkNodeValue(node.left, lower, node.value) &&
					 checkNodeValue(node.right, node.value, upper);
	}

	/**
	 * Checking if an in-order traversal of the tree is sorted is a great answer too.
	 */

	static BinaryTreeNode inOrderPrevNode;

	public static boolean checkInOrder(BinaryTreeNode node) {
		//TODO check all cases
		// https://www.geeksforgeeks.org/a-program-to-check-if-a-binary-tree-is-bst-or-not/
		if(node!=null){
			if (!checkInOrder(node.left))	return false;
			if(inOrderPrevNode!=null && node.value<= inOrderPrevNode.value) return false;
			inOrderPrevNode = node;
			return checkInOrder(node.right);
		}
		return true;
	}

}
