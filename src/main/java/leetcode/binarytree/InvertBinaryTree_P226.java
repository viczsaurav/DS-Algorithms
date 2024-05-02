package leetcode.binarytree;

/**
 * 226. Invert Binary Tree
 * https://leetcode.com/problems/invert-binary-tree/description/
 *
 * Given the root of a binary tree, invert the tree, and return its root.
 */
public class InvertBinaryTree_P226 {
    public TreeNode invertTree(TreeNode root) {

        if (root==null) return null;
        //return condition
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.right);
        invertTree(root.left);
        return root;
    }
}