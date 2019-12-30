package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class sol_94 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        TreeNode visit = root;
        while (visit != null || !stack.empty()) {
            while (visit != null) {
                stack.push(visit);
                visit = visit.left;
            }
            TreeNode next = stack.pop();
            result.add(next.val);
            if (next.right == null) {
                visit = null;
            } else {
                visit = next.right;
            }
        }
        return result;
    }
}
