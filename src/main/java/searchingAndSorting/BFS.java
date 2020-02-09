package searchingAndSorting;

public class BFS {

    public boolean breadthFirstSearch(BinaryTree tree, int searchValue){
        return false;
    }

    public static void main(String[] args) {
        int[] intArray = {17, 11, 67, 3, 93, 23, 29, 97, 53};
        BinaryTree tree = new BinaryTree();
        tree.createBinaryTree(intArray);
        tree.inOrderTraversal(tree.getRootNode());
    }
}