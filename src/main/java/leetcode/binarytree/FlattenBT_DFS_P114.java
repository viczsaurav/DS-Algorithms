package leetcode.binarytree;

import java.util.ArrayDeque;
import java.util.Deque;

public class FlattenBT_DFS_P114 {

    /**
        The approach is to save right tree first and append the left tree to the right
        and set left as null. And append saved right tree to the very bottom right
        The left tree could be just one node or a list already. Hence after insert
        into the right, we want to traverse to the very bottom right so that we
        can append the early saved right, which could be a node or a list as well.
    */
    public static void flatten(TreeNode root) {
        // Base case
        if (root==null) return;

        flatten(root.left);
        flatten(root.right);    // this is pre-order, inorder also works

        TreeNode node = root.right; // save right tree
        root.right = root.left;     // insert left tree to right
        root.left = null;           // set left tree as null

        while(root.right!=null) {   // set left tree as null
            root= root.right;
        }

        root.right = node;
    }

    public void flattenWithStack(TreeNode root) {
        if (root==null) return;

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        while (!stack.isEmpty()){
            TreeNode node = stack.pop();

            // Post Order Traversal
            if (node.right!=null)   stack.push(node.right);
            if (node.left!=null)    stack.push(node.left);

            // link the current node with the top node in the stack if exist
            if (!stack.isEmpty()){
                node.right = stack.peek();
            }

            node.left=null;
        }
    }
}
