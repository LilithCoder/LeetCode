package LeetCode;

import java.util.Stack;

public class sol_173 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    private TreeNode visit;
    private Stack<TreeNode> stack;

    public sol_173(TreeNode root) {
        visit = root;
        stack = new Stack();
    }

    /** @return the next smallest number */
    public int next() {
        while (visit != null) {
            stack.push(visit);
            visit = visit.left;
        }
        TreeNode next = stack.pop();
        if (next.right == null) {
            visit = null;
        } else {
            visit = next.right;
        }
        return next.val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return visit != null || !stack.isEmpty();
    }
}
