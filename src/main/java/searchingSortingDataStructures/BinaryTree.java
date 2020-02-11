package searchingSortingDataStructures;

public class BinaryTree{

    private Node root;

    public Node getRootNode(){
        return this.root;
    }

    public void createBinaryTree(int[] intArray){
        for (int i: intArray){
            this.add(i);
        }
    }

    public void add(int value){
        root = this.addRecursive(this.root, value );
    }

    private Node addRecursive(Node current, int value){
        if( current== null){
            return new Node(value);
        }

        if (value < current.value){
            current.left = addRecursive(current.left, value);
        } else if (value > current.value){
            current.right = addRecursive(current.right, value);
        } else {
            return current;
        }
        return current;
    }
}

class Node{
    int value;
    Node left;
    Node right;

    Node (int value){
        this.value = value;
        this.left = null;
        this.right = null;
    }
}
