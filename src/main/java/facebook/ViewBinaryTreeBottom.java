package facebook;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 *
 * Similar concept to Topview but here wee keep track from the bottom, in this case you DO NOT have to retain
 * but just keep overwriting the node at a distance.
 *
 * If there are multiple bottom-most nodes for a horizontal distance from root at same level,
 * then print the later one in level traversal.
 *
 * E.g                  8
 * 										/  \
 *                   3    10
 *                 /  \     \
 *                1   6      14
 *                   / \    /
 *                  4  7   13
 *
 * If we look at the horizontal distance of tree here node (7, 13) both have distance of +1 from centre.
 * In this case print latter one.
 * So expected output = [1, 4, 6, 13, 14]
 */

public class ViewBinaryTreeBottom {

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
				topView.put(node.distance, node.node.data);		// Keep overwriting to have only the last Node in the list
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
		List<Integer> expected_1 = Arrays.asList(new Integer[]{1, 4, 6, 13, 14});
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

		List<Integer> expected_2 = Arrays.asList(new Integer[]{4, 5, 6, 15, 16});
		List<Integer> output_2 = visibleNodes(root_2);
		check(expected_2, output_2);

	}
	public static void main(String[] args) throws IOException {
		new ViewBinaryTreeBottom().run();
	}
}
