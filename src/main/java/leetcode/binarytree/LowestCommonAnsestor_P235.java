package leetcode.binarytree;

/**
 *
    235. Lowest Common Ancestor of a Binary Search Tree
    Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.

    According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q
    as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 */
public class LowestCommonAnsestor_P235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root==null||p==null||q==null) return null;
        if (root==p||root==q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // We went to the end and were able to reach end on both side
        if (left!=null && right!=null){
            return root;
        }
        else if (left!=null) return left;
        else return right;

    }
}
