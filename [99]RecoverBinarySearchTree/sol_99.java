package LeetCode;

public class sol_99 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    TreeNode firstElement = null;
    TreeNode secondElement = null;
    TreeNode previousElement = new TreeNode(Integer.MIN_VALUE);

    public void recoverTree(TreeNode root) {
        inorderTraversal(root);
        swapNodes(firstElement, secondElement);
    }

    public void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);

        // do some business for root
        // the firstElement has not been found yet
        if (firstElement == null && previousElement.val > root.val) {
            firstElement = previousElement;
        }
        // time to find the secondElement
        if (firstElement != null && previousElement.val > root.val) {
            secondElement = root;
        }
        previousElement = root;

        inorderTraversal(root.right);
    }

    public void swapNodes(TreeNode nodeA, TreeNode nodeB) {
        int tempVal = firstElement.val;
        firstElement.val = secondElement.val;
        secondElement.val = tempVal;
    }
}
