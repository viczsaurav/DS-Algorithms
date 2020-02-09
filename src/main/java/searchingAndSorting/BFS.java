package searchingAndSorting;

public class BFS {

    public boolean breadthFirstSearchWithQueue(BinaryTree tree, int searchValue){
        return false;
    }

    public boolean breadthFirstSearchRecursive(BinaryTree tree, int searchValue){
        return false;
    }

    public static void main(String[] args) {
        int[] intArray = {17, 11, 67, 3, 93, 23, 29, 97, 53};
        BinaryTree tree = new BinaryTree();
        tree.createBinaryTree(intArray);
        tree.preOrderTraversal(tree.getRootNode());
        System.out.println("");
        tree.inOrderTraversal(tree.getRootNode());
        System.out.println("");
        tree.postOrderTraversal(tree.getRootNode());
    }
}