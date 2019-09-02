public class sol_104 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int val) {
            this.val = val;
        }
    }
    public int maxDepth(TreeNode root) {
        int res;
        res = dfsHelper(root);
        return res;
    }

    private int dfsHelper(TreeNode root) {
        // base case
        if (root == null) {
            return 0;
        }
        // recursive rule
        int left = dfsHelper(root.left);
        int right = dfsHelper(root.right);
        return Math.max(left, right) + 1;
    }
}
