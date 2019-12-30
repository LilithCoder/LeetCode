package LeetCode;

public class sol_109 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    private ListNode head;

    public TreeNode sortedListToBST(ListNode head) {
        int size = 0;
        ListNode countNode = head;
        while (countNode != null) {
            countNode = countNode.next;
            size++;
        }
        this.head = head;
        return convertListToBST(0, size - 1);
    }

    public TreeNode convertListToBST(int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode left = convertListToBST(start, mid - 1);
        TreeNode root = new TreeNode(this.head.val);
        root.left = left;
        this.head = this.head.next;
        TreeNode right = convertListToBST(mid + 1, end);
        root.right = right;
        return root;
    }
}
