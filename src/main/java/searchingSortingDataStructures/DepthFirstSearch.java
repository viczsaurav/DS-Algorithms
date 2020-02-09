package searchingSortingDataStructures;

public class DepthFirstSearch {

	/**
	 * DFS - Pre order traversal using DFS recursion
	 * @param node
	 */
	public static void preOrderTraversal(BinaryTree.Node node){
		if(node!=null){
			System.out.print(node.value + "\t");
			preOrderTraversal(node.left);
			preOrderTraversal(node.right);
		}
	}

	/**
	 * DFS - In order traversal using DFS recursion
	 * @param node
	 */
	public static void inOrderTraversal(BinaryTree.Node node){
		if(node!=null){
			inOrderTraversal(node.left);
			System.out.print(node.value + "\t");
			inOrderTraversal(node.right);
		}
	}

	/**
	 * DFS - Post order traversal using DFS recursion
	 * @param node
	 */
	public static void postOrderTraversal(BinaryTree.Node node){
		if(node!=null){
			postOrderTraversal(node.left);
			postOrderTraversal(node.right);
			System.out.print(node.value + "\t");
		}
	}

	public static void main(String[] args) {
		int[] intArray = {17, 11, 67, 3, 93, 23, 29, 97, 53};
		BinaryTree tree = new BinaryTree();
		tree.createBinaryTree(intArray);
		preOrderTraversal(tree.getRootNode());
		System.out.println("");
		inOrderTraversal(tree.getRootNode());
		System.out.println("");
		postOrderTraversal(tree.getRootNode());
	}
}
