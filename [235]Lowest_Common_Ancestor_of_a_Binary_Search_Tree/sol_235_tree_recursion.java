public class sol_235_tree_recursion {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    // simple recursion question
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // p&q are in the left side of the root node
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        // p&q are in the right side of the root node
        else if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }
}
