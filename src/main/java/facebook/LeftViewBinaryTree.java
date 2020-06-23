package facebook;

import java.io.*;
import java.util.*;
// Add any extra import statements you may need here


public class LeftViewBinaryTree {

	class Node {
		int data;
		Node left;
		Node right;
		Node() {
			this.data = 0;
			this.left = null;
			this.right = null;
		}
		Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}


	/**
	 * Using BFS - iterative
	 * @param root
	 * @return
	 */
	int visibleNodes(Node root) {
		Deque<Node> queue = new ArrayDeque<>();
		Node prev=null;
		queue.offerLast(root);
		queue.offerLast(new Node(-1));  // Dummy Node for level breaker

		int count=0;

		while(queue.size()>0){
			Node node = queue.pollFirst();
			if (prev==null || prev.data==-1) count++;
			prev=node;

			if (node.data==-1){
				if(queue.size()==0){
					break;
				}  // hit the last dummy node
				queue.offerLast(new Node(-1)); // Else new level start, insert dummy node
			}

			if (node.left!=null)  queue.offerLast(node.left);
			if (node.right!=null) queue.offerLast(node.right);

		}

		return count;

	}

	/**
	 * Recursive Approach
	 */

	int max_level=0;
	int nodeCount=0;

	int visibleNodesRecursive(Node root){
		visibleNodesRecursive(root, 1);
		return nodeCount;
	}

	void visibleNodesRecursive(Node root, int level){
		if(root==null)	return;

		if (max_level< level){
			System.out.println(root.data);
			nodeCount++;
			max_level=level;
		}
		if(root.left!=null)	visibleNodesRecursive(root.left,level+1);
		if(root.right!=null) visibleNodesRecursive(root.right, level+1);
	}


	int test_case_number = 1;
	void check(int expected, int output) {
		boolean result = (expected == output);
		char rightTick = '\u2713';
		char wrongTick = '\u2717';
		if (result) {
			System.out.println(rightTick + " Test #" + test_case_number);
		}
		else {
			System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
			printInteger(expected);
			System.out.print(" Your output: ");
			printInteger(output);
			System.out.println();
		}
		test_case_number++;
	}
	void printInteger(int n) {
		System.out.print("[" + n + "]");
	}
	public void run() throws IOException {

		Node root_1 = new Node(8);
		root_1.left = new Node(3);
		root_1.right = new Node(10);
		root_1.left.left = new Node(1);
		root_1.left.right = new Node(6);
		root_1.right.right = new Node(14);
		root_1.left.right.left = new Node(4);
		root_1.left.right.right = new Node(7);
		root_1.right.right.left = new Node(13);
		int expected_1 = 4;
		int output_1 = visibleNodes(root_1);
		int output_1_1 = visibleNodesRecursive(root_1);
		check(expected_1, output_1);
		check(expected_1, output_1_1);

		System.out.println("----------------------");

		//RESET GLOBAL VALUES
		this.max_level=0;
		this.nodeCount=0;

		Node root_2 = new Node(10);
		root_2.left = new Node(8);
		root_2.right = new Node(15);
		root_2.left.left = new Node(4);
		root_2.left.left.right = new Node(5);
		root_2.left.left.right.right = new Node(6);
		root_2.right.left = new Node(14);
		root_2.right.right = new Node(16);

		int expected_2 = 5;
		int output_2 = visibleNodes(root_2);
		int output_2_1 = visibleNodesRecursive(root_2);
		check(expected_2, output_2);
		check(expected_2, output_2_1);

	}
	public static void main(String[] args) throws IOException {
		new LeftViewBinaryTree().run();
	}
}
