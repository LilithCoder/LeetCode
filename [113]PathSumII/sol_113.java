package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class sol_113 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        List<Integer> current = new ArrayList<>();
        current.add(root.val);
        pathSumHelper(sum, root.val, root, current, result);
        return result;
    }
    public void pathSumHelper(int target,int sum, TreeNode root, List<Integer> current, List<List<Integer>> result) {
        if (root.left == null && root.right == null && sum == target) {
            result.add(new ArrayList<Integer>(current));
            return;
        }
        if (root.left != null) {
            current.add(root.left.val);
            pathSumHelper(target, sum + root.left.val, root.left, current, result);
            current.remove(current.size() - 1);
        }
        if (root.right != null) {
            current.add(root.right.val);
            pathSumHelper(target, sum + root.right.val, root.right, current, result);
            current.remove(current.size() - 1);
        }
    }
}
