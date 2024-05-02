package leetcode.binarytree;

import java.util.*;

/**
 * https://leetcode.com/problems/path-sum-ii/
 *
 * Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where the sum of the node values in the path equals targetSum. Each path should be returned as a list of the node values, not node references.
 * A root-to-leaf path is a path starting from the root and ending at any leaf node. A leaf is a node with no children.
 */

public class PathSum2_P113 {

    List<List<Integer>> paths = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root==null) return new ArrayList<>();
        findPath(root, targetSum, new ArrayList<>());
        return paths;
    }

    private void findPath(TreeNode root, int targetSum, List<Integer> pathList){
        if (root==null) return;

        pathList.add(root.val);
        findPath(root.left, targetSum-root.val, pathList);
        findPath(root.right, targetSum-root.val, pathList);

        if(root.left==null && root.right==null && targetSum-root.val==0){
            paths.add(new ArrayList<>(pathList));
        }
        pathList.remove(pathList.size()-1);
        return;
    }
}
