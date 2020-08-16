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
	public static int findSecondLargest(BinaryTreeNode node){

		// Base case : Check for null, single Node
		if (node==null || node.left==null && node.right==null){
			throw new IllegalArgumentException("At least 2 nodes required");
		}

		// Since its a BST, the rightmost element will always be the largest
		while(true){
			// Case 1: When your rightmost element is a leaf node, thus the parent should be 2nd largest
			if (node.right!=null && node.right.left==null && node.right.right==null){
				return node.value;
			}

			// Case 2: When your rightmost element(largest) has a left subtree
			// 			Remember case when only left subtree is present, thus root.left is the secondLargestNode
			if (node.left!=null && node.right==null){
				return (getRightMostNodeIterative(node.left).value);
			}

			//else continue along right path
			node=node.right;
		}
	}

	private static BinaryTreeNode getRightMostNodeIterative(BinaryTreeNode node) {
		while(node.right!=null){
			node = node.right;
		}
		return node;
	}
}
