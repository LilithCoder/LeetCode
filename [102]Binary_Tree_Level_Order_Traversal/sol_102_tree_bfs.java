import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class sol_102_tree_bfs {
    class TreeNode {
        int val;
        TreeNode right;
        TreeNode left;
        TreeNode(int val) {
            this.val = val;
        }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        // error checking
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> currLevel = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode currNode = queue.poll();
                currLevel.add(currNode.val);
                if (currNode.left != null) {
                    queue.add(currNode.left);
                }
                if (currNode.right != null) {
                    queue.add(currNode.right);
                }
            }
            result.add(currLevel);
        }
        return result;
    }
}
