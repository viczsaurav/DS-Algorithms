package searchingSortingDataStructures;

import java.util.LinkedList;
import java.util.Queue;

public class LevelByLevelTraversal {

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

	public static void main(String[] args) {
		int[] intArray = {17, 11, 67, 3, 93, 23, 29, 97, 53};
		BinaryTree tree = new BinaryTree();
		tree.createBinaryTree(intArray);

		levelByLevelTraversal(tree.getRootNode());
	}
}
