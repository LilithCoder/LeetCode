package LeetCode;

public class sol_654 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return helper(0, nums.length - 1, nums);
    }
    public TreeNode helper(int start, int end, int[] nums) {
        if (start > end) return null;
        int indexOfMax= start;
        for (int i = start; i <= end; i++) {
            if (nums[i] > nums[indexOfMax]) {
                indexOfMax = i;
            }
        }
        TreeNode root = new TreeNode(nums[indexOfMax]);
        root.left = helper(start, indexOfMax - 1, nums);
        root.right = helper(indexOfMax + 1, end, nums);
        return root;
    }
}
