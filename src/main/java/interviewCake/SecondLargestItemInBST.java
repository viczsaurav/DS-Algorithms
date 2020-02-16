package interviewCake;

public class SecondLargestItemInBST {

	/**
	 * Write a method to find the 2nd largest element in a binary search tree.
	 */


	public static int findSecondLargest(BinaryTreeNode rootNode) {

		if(rootNode==null ||
						(rootNode.left==null && rootNode.right==null)){
			throw new IllegalArgumentException("Atleast 2 nodes required.");
		}

		/**
		 * Check 1 : Traverse right and check for rightmostNode(largest),
		 * 	         return the 2nd last
 		 */
		if (rootNode.right!=null &&  rootNode.right.left==null && rootNode.right.right==null) {
			return rootNode.value;
		}

		/** Check 2:
		 * - if reached this part means we reaached largest node and there is a left node of it.
		 * - Check largest value in left subtree which will be 2nd largest value of tree
		 */
		if(rootNode.left!=null&& rootNode.right==null){
			return getRightMostNode(rootNode.left);
		}

		/** Else continue along right path */
		return findSecondLargest(rootNode.right);
	}

	/**
	 * return the rightmost/largest node in tree
	 * @param node
	 * @return
	 */
	public static int getRightMostNode(BinaryTreeNode node){
		if(node.right!=null){
			return getRightMostNode(node.right);
		}
		return node.value;
	}
}
