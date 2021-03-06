package facebook;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * While looking for topview of a tree, the idea is that we will only see the outer rim of the tree
 * and all the internal nodes having an existing node at same distance wrt to root will hide it.
 *
 * So here, we follow BFS from thr top-> to get all 'first' nodes at a distance and return
 *
 */

public class ViewBinaryTreeTop {

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

	class NodeWithWidth {
		Node node;
		int distance;

		NodeWithWidth(Node n, int distance){
			this.node=n;
			this.distance=distance;
		}
	}

	List<Integer> visibleNodes(Node root){
		Deque<NodeWithWidth> queue =  new ArrayDeque<>();
		queue.offerLast(new NodeWithWidth(root, 0));
		queue.offerLast(new NodeWithWidth(null,  -1));	// Dummy Node as level breaker

		Map<Integer, Integer> topView = new HashMap<>();

		while(queue.size()>0){
			NodeWithWidth node = queue.pollFirst();

			if (node.node==null){
				if(queue.size()==0){
					break;
				}
				queue.offerLast(new NodeWithWidth(null,  -1));
			}
			else {
				if(topView.get(node.distance)==null)
					topView.put(node.distance, node.node.data);		// Retain only first node at a distance.
				if(node.node.left!=null)
					queue.offerLast(new NodeWithWidth(node.node.left, node.distance-1));
				if(node.node.right!=null)
					queue.offerLast(new NodeWithWidth(node.node.right, node.distance+1));
			}
		}
//
		return topView.values().stream().collect(Collectors.toList());
//		return (new ArrayList<>(topView.values()));



	}

	int test_case_number = 1;
	void check(List<Integer> expected, List<Integer> output) {
		boolean result = (expected.containsAll(output) && output.containsAll(expected));
		char rightTick = '\u2713';
		char wrongTick = '\u2717';
		if (result) {
			System.out.println(rightTick + " Test #" + test_case_number);
		}
		else {
			System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
			printList(expected);
			System.out.print(" Your output: ");
			printList(output);
			System.out.println();
		}
		test_case_number++;
	}
	void printList(List<Integer> list) {
		System.out.println(list.toString());
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
		List<Integer> expected_1 = Arrays.asList(new Integer[]{1, 3, 8, 10,14});
		List<Integer> output_1 = visibleNodes(root_1);
		check(expected_1, output_1);

		System.out.println("----------------------");

		Node root_2 = new Node(10);
		root_2.left = new Node(8);
		root_2.right = new Node(15);
		root_2.left.left = new Node(4);
		root_2.left.left.right = new Node(5);
		root_2.left.left.right.right = new Node(6);
		root_2.right.left = new Node(14);
		root_2.right.right = new Node(16);

		List<Integer> expected_2 = Arrays.asList(new Integer[]{4, 8, 10, 15, 16});
		List<Integer> output_2 = visibleNodes(root_2);
		check(expected_2, output_2);

	}
	public static void main(String[] args) throws IOException {
		new ViewBinaryTreeTop().run();
	}
}
