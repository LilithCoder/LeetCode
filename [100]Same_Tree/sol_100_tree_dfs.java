public class sol_100_tree_dfs {
    class TreeNode {
        int val;
        TreeNode right;
        TreeNode left;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        // base case
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else if (p.val != q.val) {
            return false;
        }
        // recursive call
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
