import org.w3c.dom.NodeList;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PQ {

    class ListNode {
        int val;
        ListNode next;
        public ListNode (int val) {
            this.val = val;
        }
    }

    class NodeComparator implements Comparator<ListNode> {
        @Override
        public int compare(ListNode l1, ListNode l2) {
            return l1.val - l2.val;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {

        if (lists.length == 0 || lists == null) {
            return null;
        }

        PriorityQueue<ListNode> pqueue = new PriorityQueue(lists.length, new NodeComparator());

        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null){
                pqueue.add(lists[i]);
            }
        }

        ListNode dummyHead = new ListNode(-1);
        ListNode currentNode = dummyHead;

        while (!pqueue.isEmpty()) {
            ListNode newlyAdded = pqueue.poll();
            currentNode.next = newlyAdded;
            currentNode = currentNode.next;
            if (newlyAdded.next != null) {
                pqueue.add(newlyAdded.next);
            }
        }
        return dummyHead.next;
    }
}
