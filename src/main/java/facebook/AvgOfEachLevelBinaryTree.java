package facebook;

import java.util.*;

public class AvgOfEachLevelBinaryTree {

	/*
	            4
	           / \
	          7   9
	         / \    \
	        10  2    6
	             \
	              6
	             /
	            2

	     Output: [4,8,6,6,2]

	     avgList = [4.0,8.0, 6.0,6.0, 2.0]
	     queue: []
	     curr=null
	     sum=0 count=0
	 */

	static class Node {
		int val;
		Node left;
		Node right;

		public Node(int val){
			this.val=val;
			this.left=null;
			this.right=null;
		}
		public Node(int val, Node left, Node right){
			this.val=val;
			this.left=left;
			this.right=right;
		}

	}


	public static void main(String[] args) {
		Node root =  new Node(4);
		root.left = new Node(7, new Node(10), new Node(2, null, new Node(6, new Node(2), null)));
		root.right = new Node(9, null, new Node(6));

		for (double i : collect(root)){
			System.out.print(i + " , ");
		}

	}

	private static List<Double> collect(Node root){
		List<Double> avgList = new ArrayList<>();
		Deque<Node> queue =  new ArrayDeque<>();
		if(root==null || root.val==0){
			avgList.add(0.0);
			return avgList;
		}
		int sum=0, count=0;
		queue.offerLast(root);
		queue.offerLast(new Node(-1));	// Dummy Node, level breaker

		while(queue.size()>0){
			Node curr = queue.pollFirst();

			if (curr.val==-1){
				avgList.add((double)(sum/count));
				sum=0; count=0;

				// Check for end of tree
				if (queue.size()==0){
					break;
				}
				queue.add(new Node(-1));
			}
			else {
				sum+= curr.val;
				count++;

				if (curr.left!=null)	queue.offerLast(curr.left);
				if (curr.right!=null)	queue.offerLast(curr.right);
			}
		}
		return avgList;
	}
}
