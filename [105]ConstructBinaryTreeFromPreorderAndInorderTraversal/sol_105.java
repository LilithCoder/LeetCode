package LeetCode;

public class sol_105 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return dfs(0, 0, inorder.length - 1, preorder, inorder);
    }

    public TreeNode dfs(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preStart > preorder.length - 1 || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int inIndexOfRoot = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                inIndexOfRoot = i;
            }
        }
        root.left = dfs(preStart + 1, inStart, inIndexOfRoot - 1, preorder, inorder);
        root.right = dfs(preStart + inIndexOfRoot - inStart + 1, inIndexOfRoot + 1, inEnd, preorder, inorder);
        return root;
    }
}
