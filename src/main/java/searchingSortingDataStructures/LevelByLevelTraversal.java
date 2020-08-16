package searchingSortingDataStructures;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class LevelByLevelTraversal {

	/**
	 * Using Null item as level breaker
	 * @param root
	 */
	public static void levelByLevelTraversal(Node root){
		Queue<Node> bft = new LinkedList<>();
		bft.offer(root);
		bft.offer(null);

		while(!bft.isEmpty()){
			Node currNode = bft.poll();

			if(currNode == null){
				if (!bft.isEmpty()){				// Break condition
					System.out.println();
					bft.offer(null);
				}
			} else{
				System.out.print(currNode.value + "\t");
				if(currNode.left!= null)    bft.add(currNode.left);
				if(currNode.right!= null)   bft.add(currNode.right);
			}
		}
	}

	/**
	 * Using Deque with queue Size as level breaker
	 * @param root
	 */
	public static void levelByLevelTraversalWithDeque(Node root){
		Deque<Node> queue = new ArrayDeque<>();
		queue.offerFirst(root);
		int size=1;

		while(!queue.isEmpty()){
			Node node = queue.pollLast();
			size--;

			System.out.print(node.value+ "\t");
			if(node.left!=null)	queue.offerFirst(node.left);
			if(node.right!=null)	queue.offerFirst(node.right);

			// Level break
			if (size==0){
				System.out.println();
				size= queue.size();
			}
		}

	}

	public static void main(String[] args) {
		int[] intArray = {17, 11, 67, 3, 93, 23, 29, 97, 53};
		BinaryTree tree = new BinaryTree();
		tree.createBinaryTree(intArray);

		levelByLevelTraversal(tree.getRootNode());
		System.out.println("\n----------------------");
		levelByLevelTraversalWithDeque(tree.getRootNode());
	}
}
