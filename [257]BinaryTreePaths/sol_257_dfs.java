import java.util.ArrayList;
import java.util.List;

public class sol_257_dfs {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) return result;
        String str = "";
        dfs(root, str, result);
        return result;
    }
    private void dfs(TreeNode root, String str, List<String> result) {
        str += root.val;
        if (root.left == null && root.right == null) {
            result.add(str);
            return;
        }
        if (root.left != null) {
            dfs(root.left, str + "->", result);

        }
        if (root.right != null) {
            dfs(root.right, str + "->", result);
        }
    }
}
