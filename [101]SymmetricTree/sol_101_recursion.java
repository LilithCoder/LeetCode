public class sol_101_recursion {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return recursive(root.left, root.right);
    }

    private boolean recursive(TreeNode left, TreeNode right) {
        if (left == null && right != null) return false;
        if (left != null && right == null) return false;
        if (left == null && right == null) return true;
        if (left.val != right.val) return false;
        return recursive(left.left, right.right) && recursive(left.right, right.left);
    }
}
