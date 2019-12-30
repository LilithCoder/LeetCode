package LeetCode;

public class sol_114 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    TreeNode previous = null;

    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.right);
        flatten(root.left);
        root.right = previous;
        root.left = null;
        previous = root;
    }
}
