package interviewCake;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

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

	/**
	 * Remember to use a new static class with *level/depth* information
	 * when we require to keep track of it. Keeping a single height variable can result in errors
	 */
	private static class NodeLevelPair {
		BinaryTreeNode node;
		int level;

		NodeLevelPair(BinaryTreeNode node, int level){
			this.node = node;
			this.level = level;
		}
	}

	public static boolean isBalanced(BinaryTreeNode treeRoot) {

		// Using Stack here, but a Deque is recommended. Changes are marked as below
		Stack<NodeLevelPair> stack = new Stack<>();
		stack.push(new NodeLevelPair(treeRoot,0));

		// Deque Implementation (Double Ended Queue)
//		Deque<NodeLevelPair> deque = new ArrayDeque<>();
//		deque.offerFirst(new NodeLevelPair(treeRoot,0));

		int min=Integer.MAX_VALUE;
		int max=Integer.MIN_VALUE;

		while(!stack.empty()) {
//		while(!deque.isEmpty()) {
			NodeLevelPair pairNode= stack.pop();
//			NodeLevelPair pairNode= deque.pollFirst();
			BinaryTreeNode node = pairNode.node;
			int level = pairNode.level;

			if(node.left!=null)
				stack.push(new NodeLevelPair(node.left,level+1));
//				deque.offerFirst(new NodeLevelPair(node.left,level+1));
			if(node.right!=null)
				stack.push(new NodeLevelPair(node.right,level+1));
//				deque.offerFirst(new NodeLevelPair(node.right,level+1));
			if(node.left==null && node.right==null) {
				min = Math.min(min,level);
				max = Math.max(max,level);
			}
			if ((max-min)>1)	return false;
		}
		return true;
	}
}
