package interviewCake;

public class SecondLargestItemInBST {

	/**
	 * With recursion
	 *
	 * Write a method to find the 2nd largest element in a binary search tree.
	 * It take O(h) time (where 'h' = height of the tree) and O(h) space.
	 * again, that's O(lgn) if the tree is balanced, O(n) otherwise
	 */

	public static int findSecondLargestRecursion(BinaryTreeNode rootNode) {

		if(rootNode==null ||
						(rootNode.left==null && rootNode.right==null)){
			throw new IllegalArgumentException("Atleast 2 nodes required.");
		}

		// Check 1 : Traverse right and check for rightmostNode(largest), return the 2nd last
		if (rootNode.right!=null &&  rootNode.right.left==null && rootNode.right.right==null) {
			return rootNode.value;
		}

		// - if reached this part means we reaached largest node and there is a left node of it.
		// - Check largest value in left subtree which will be 2nd largest value of tree
		if(rootNode.left!=null&& rootNode.right==null){
			return getRightMostNodeRecursion(rootNode.left);
		}

		// Else continue along right path
		return findSecondLargestRecursion(rootNode.right);
	}

	// return the rightmost/largest node in tree
	public static int getRightMostNodeRecursion(BinaryTreeNode node){
		if(node.right!=null){
			return getRightMostNodeRecursion(node.right);
		}
		return node.value;
	}


	/**
	 * without recursion
	 *
	 * We're doing one walk down our BST, which means O(h) time, where h is the height of the tree
	 * (again, that's O(lg(n)) if the tree is balanced, O(n) otherwise). O(1) space.
	 */

	public static int findSecondLargest(BinaryTreeNode rootNode) {

		if(rootNode==null ||
						(rootNode.left==null && rootNode.right==null)){
			throw new IllegalArgumentException("Atleast 2 nodes required.");
		}

		BinaryTreeNode current = rootNode;

		while(true){
			// Check 1 : Traverse right and check for rightmostNode(largest), return the 2nd last
			if (current.right!=null &&  current.right.left==null && current.right.right==null) {
				return current.value;
			}

			// - if reached this part means we reaached largest node and there is a left node of it.
			// - Check largest value in left subtree which will be 2nd largest value of tree
			if(current.left!=null&& current.right==null){
				return getRightMostNode(current.left);
			}

			// Else continue along right path
			current = current.right;
		}
	}

	public static int getRightMostNode(BinaryTreeNode node){
		BinaryTreeNode largest = null;
		BinaryTreeNode current = node;

		while(current!=null){
			if(current.right==null){
				largest = current;
			}
			current = current.right;
		}

		return largest.value;
	}
}
