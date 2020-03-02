package searchingSortingDataStructures;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearchTree {

    public static boolean breadthFirstSearch(Node root, int searchValue){

        System.out.println("Searching for: "+ searchValue);
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

    public static boolean breadthFirstSearchDeque(Node root, int searchValue){
        System.out.println("Searching for: "+ searchValue);
        Deque<Node> bft = new ArrayDeque<>();
        bft.offerFirst(root);

        while(!bft.isEmpty()){
            Node currNode = bft.pollLast();
            if(currNode.value== searchValue){
                return true;
            } else{
                if(currNode.left!= null)    bft.offerFirst(currNode.left);
                if(currNode.right!= null)   bft.offerFirst(currNode.right);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] intArray = {17, 11, 67, 3, 93, 23, 29, 97, 53};
        BinaryTree tree = new BinaryTree();
        tree.createBinaryTree(intArray);

        int searchValue1 = 23;
        int searchValue2 = 21;

        System.out.println(breadthFirstSearch(tree.getRootNode(), searchValue1));
        System.out.println(breadthFirstSearch(tree.getRootNode(), searchValue2));

        System.out.println("----- Deque -----");
        System.out.println(breadthFirstSearchDeque(tree.getRootNode(), searchValue1));
        System.out.println(breadthFirstSearchDeque(tree.getRootNode(), searchValue2));

    }
}
