package cci;

import java.util.ArrayDeque;
import java.util.Queue;

public class SumAtEachTreeLevel {

	public static void main(String[] args) {
		Node root = Node.createTree();
		displaySumForEachLevel(root);

	}

	static class Node {
		int value;
		Node left;
		Node right;

		public Node(int val) {
			this.value = val;
			this.left = null;
			this.right = null;
		}

		public static Node createTree() {
			Node root = new Node(12);
			root.left = new Node(23);
			root.right = new Node(18);
			root.left.left = new Node(11);
			root.left.right = new Node(43);
			root.right.left = new Node(12);
			root.left.left.left = new Node(56);
			root.left.left.right = new Node(78);
			root.right.left.right = new Node(98);
			return root;
		}
	}

	public static void displaySumForEachLevel(Node root) {
		Queue<Node> q = new ArrayDeque<>();
		Node dummy = new Node(Integer.MAX_VALUE);

		if (root == null) {
			System.out.println("No Element found");
			return;
		}

		q.add(root);
		q.add(dummy);

		int sum = 0;
		int level = 0;

		while (!q.isEmpty()) {
			root = q.remove();

			if (root.equals(dummy)) {
				System.out.println("Level : " + level + ", Sum : " + sum);
				sum = 0;
				level++;
				if (q.size() != 0)
					q.add(dummy);
			} else {
				sum += root.value;
				if (root.left != null)
					q.add(root.left);
				if (root.right != null)
					q.add(root.right);
			}
		}
	}

}
