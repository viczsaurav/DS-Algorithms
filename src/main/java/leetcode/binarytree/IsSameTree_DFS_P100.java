package leetcode.binarytree;

public class IsSameTree_DFS_P100 {

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        // Base return conditions
        if (p==null && q==null) return true;
        if (p==null || q==null) return false;   // At least one node is not null
        if (p.val!=q.val)       return false;   // Both not null then compare value

        return (isSameTree(p.left, q.left) && isSameTree(p.right, q.right));
    }

    public static void main(String[] args) {
        TreeNode p1 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode q1 = new TreeNode(1, new TreeNode(2), new TreeNode(3));

        System.out.println("Expected: [true], Result: "+ isSameTree(p1, q1));

        TreeNode p2 = new TreeNode(1, new TreeNode(2), null);
        TreeNode q2 = new TreeNode(1, null, new TreeNode(2));

        System.out.println("Expected: [false], Result: "+ isSameTree(p2, q2));

        TreeNode p3 = new TreeNode(1, new TreeNode(2), new TreeNode(1));
        TreeNode q3 = new TreeNode(1, new TreeNode(1), new TreeNode(2));

        System.out.println("Expected: [false], Result: "+ isSameTree(p3, q3));
    }
}
