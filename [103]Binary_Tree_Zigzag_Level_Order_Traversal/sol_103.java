import java.util.*;

/**
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its zigzag level order traversal as:
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 */

public class sol_103 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // initialize the return value
        List<List<Integer>> resList = new ArrayList<>();

        // error checking
        if (root == null) {
            return resList;
        }

        // add queue for bfs
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        // add boolean value to represent whether the current level is reversed or not
        boolean isReversed = false;

        while(!queue.isEmpty()) {
            int sizeOfQueue = queue.size();
            List<Integer> currentLevel = new ArrayList<>();
            for (int i = 0; i < sizeOfQueue; i++) {
                TreeNode topNode = queue.poll();
                currentLevel.add(topNode.val);
                if (topNode.left != null) {
                    queue.add(topNode.left);
                }
                if (topNode.right != null) {
                    queue.add(topNode.right);
                }
            }

            // if the isReversed is true, then reverse the order of the current level
            if (isReversed) {
                Collections.reverse(currentLevel);
            }
            resList.add(currentLevel);
            isReversed = !isReversed;
        }
        return resList;
    }
}
