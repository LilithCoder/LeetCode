package LeetCode;

public class sol_1120 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    double result;
    public double maximumAverageSubtree(TreeNode root) {
        result = 0;
        maximumAverageSubtreeHelper(root);
        return result;
    }
    public int[] maximumAverageSubtreeHelper(TreeNode root) {
        if (root == null) return new int[]{0, 0};
        int sum = root.val + maximumAverageSubtreeHelper(root.right)[0] + maximumAverageSubtreeHelper(root.left)[0];
        int num = 1 + maximumAverageSubtreeHelper(root.right)[1] + maximumAverageSubtreeHelper(root.left)[1];
        result = Math.max((double)sum / (double)num, result);
        return new int[]{sum, num};
    }
}
