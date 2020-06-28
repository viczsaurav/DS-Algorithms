package searchingSortingDataStructures;

public class InOrderTraversal {


	/**
	 * DFS - In order traversal using DFS recursion
	 * @param node
	 */
	public static void inOrderTraversal(Node node){
		if(node!=null){
			inOrderTraversal(node.left);
			System.out.print(node.value + "\t");
			inOrderTraversal(node.right);
		}
	}

	public static void inOrderIterative(Node node){
		//TODO
	}
}
