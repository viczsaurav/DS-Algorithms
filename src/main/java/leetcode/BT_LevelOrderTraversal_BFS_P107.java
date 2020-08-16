package leetcode;

import java.util.*;

public class BT_LevelOrderTraversal_BFS_P107 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val;}
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> out = new ArrayList<>();
        List<Integer> level = new ArrayList<>();

        if (root == null) return out;

        // For BFS, don't use Deque with `int` val TreeNode, as you cannot add null TreeNode to Deque.
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                // Level Break
                out.add(0, new ArrayList<>(level));
                level = new ArrayList<>();

                // queue empty means end of tree
                if (!queue.isEmpty()) {
                    queue.offer(null);
                } else {
                    level.add(node.val);
                    if (node.left != null) queue.offer(node.left);
                    if (node.right != null) queue.offer(node.right);
                }
            }
        }
        return out;
    }
}
