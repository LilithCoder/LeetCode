public class sol_108_dfs_tree {
    class TreeNode {
        int val;
        TreeNode right;
        TreeNode left;
        TreeNode(int val) {
            this.val = val;
        }

    }
    // converted sorted array to BST (classical DFS solution)
    public TreeNode sortedArrayToBST(int[] nums) {
        // error checking
        if (nums == null || nums.length == 0) {
            return null;
        }
        return dfs(nums, 0, nums.length - 1);
    }

    private TreeNode dfs(int[] nums, int left, int right) {
        // base case
        if (left > right) {
            return null;
        }
        // Get the middle node and make it root
        int mid = (left + right + 1) / 2;
        TreeNode currNode = new TreeNode(nums[mid]);

        // Recursively do the same for the left subtree and right subtree
        currNode.left = dfs(nums, left, mid - 1);
        currNode.right = dfs(nums, mid + 1, right);

        // return
        return currNode;
    }
}
