package LeetCode;

public class sol_206 {
    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode reversedList = head;
        ListNode remainingList = head.next;
        reversedList.next = null;
        while (remainingList != null) {
            ListNode tempNode = remainingList;
            remainingList = remainingList.next;
            tempNode.next = reversedList;
            reversedList = tempNode;
        }
        return reversedList;
    }
}
