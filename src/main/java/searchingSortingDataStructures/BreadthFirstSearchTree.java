package searchingSortingDataStructures;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearchTree {

    public static boolean breadthFirstSearch(Node root, int searchValue){

        Queue<Node> bft = new LinkedList<>();
        bft.add(root);

        while(!bft.isEmpty()){
            Node currNode = bft.remove();
            if(currNode.value== searchValue){
                return true;
            } else{
                if(currNode.left!= null)    bft.add(currNode.left);
                if(currNode.right!= null)   bft.add(currNode.right);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] intArray = {17, 11, 67, 3, 93, 23, 29, 97, 53};
        BinaryTree tree = new BinaryTree();
        tree.createBinaryTree(intArray);

        int searchValue1 = 23;
        System.out.println(breadthFirstSearch(tree.getRootNode(), searchValue1));
        int searchValue2 = 21;
        System.out.println(breadthFirstSearch(tree.getRootNode(), searchValue2));
    }
}
