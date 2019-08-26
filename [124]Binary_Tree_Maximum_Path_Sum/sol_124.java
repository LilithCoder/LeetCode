public class sol_124 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }
    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        int[] result = {Integer.MIN_VALUE};
        dfs(root, result);
        return result[0];
    }

    private int dfs(TreeNode root, int[] result) {
        int left = root.left != null ? Math.max(dfs(root.left, result), 0) : 0;
        int right = root.right != null ? Math.max(dfs(root.right, result), 0) : 0;
        result[0] = Math.max(result[0], left + right + root.val);
        return root.val + Math.max(left, right);
    }
}
