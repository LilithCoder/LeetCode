import java.util.List;

public class DivideAndConquer {

    /**
     * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
     *
     * Example:
     *
     * Input:
     * [
     *   1->4->5,
     *   1->3->4,
     *   2->6
     * ]
     * Output: 1->1->2->3->4->4->5->6
     */
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {

        int start = 0;
        int end = lists.length - 1;

        if (lists.length == 0) {
            return null;
        }

        return mergeHelper(lists, start, end);
    }

    private ListNode mergeHelper(ListNode[] lists, int start, int end) {
        //base case
        if (start == end) {
            return lists[start];
        }

        int mid = start + (end - start ) / 2;

        ListNode leftListNode = mergeHelper(lists, start, mid);
        ListNode rightListNode = mergeHelper(lists, mid + 1, end);

        //the following is the same as merging two sorted lists
        ListNode dummyHead = new ListNode(-1);
        ListNode currentNode = dummyHead;

        while (leftListNode != null && rightListNode != null) {
            if (leftListNode.val <= rightListNode.val) {
                currentNode.next = leftListNode;
                leftListNode = leftListNode.next;
                currentNode = currentNode.next;
            } else {
                currentNode.next = rightListNode;
                rightListNode = rightListNode.next;
                currentNode = currentNode.next;
            }
        }
        currentNode.next = leftListNode == null ? rightListNode : leftListNode;
        return dummyHead.next;
    }
}
