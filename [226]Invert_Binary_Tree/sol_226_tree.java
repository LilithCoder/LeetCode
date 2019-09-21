public class sol_226_tree {
    class TreeNode {
        int val;
        TreeNode right;
        TreeNode left;
        TreeNode(int val) {
            this.val = val;
        }
    }
    // dfs/recursion
    public TreeNode invertTree(TreeNode root) {
        // base case
        if (root == null) {
            return null;
        }
        // swap the left node and right node
        TreeNode tempNode = root.left;
        root.left = root.right;
        root.right = tempNode;
        // recursive call
        root.left = invertTree(root.left);
        root.right = invertTree(root.right);
        return root;
    }
}
