public class iterationSol {

    /**
     * Merge two sorted linked lists and return it as a new list.
     * The new list should be made by splicing together the nodes of the first two lists.
     *
     * Example:
     *
     * Input: 1->2->4, 1->3->4
     * Output: 1->1->2->3->4->4
     */

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */

    class ListNode {
        int val;
        ListNode next;
        ListNode (int val) {
            this.val = val;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        ListNode dummyHead = new ListNode(-1);
        ListNode currentNode = dummyHead;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                currentNode.next = l1;
                l1 = l1.next;
            } else {
                currentNode.next = l2;
                l2 = l2.next;
            }
            currentNode = currentNode.next;
        }
        // exactly one of l1 and l2 can be non-null at this point, so connect
        // the non-null list to the end of the merged list.

        currentNode.next = l1 == null ? l2 : l1;
        return dummyHead.next;
    }
}
