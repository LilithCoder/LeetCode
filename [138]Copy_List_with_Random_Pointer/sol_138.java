import java.util.HashMap;
import java.util.Map;

/**
   Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/

public class sol_138 {
    class Node {
        int val;
        Node next;
        Node random;
        public Node (int val) {
            this.val = val;
        }
    }
    public Node copyRandomList(Node head) {

        // corner case
        if (head == null) return null;

        // sentinel node to help construct the deep copy
        Node dummyHead = new Node(-1);
        Node currNode = dummyHead;

        // maintaining the mapping between the original node and the corresponding node in the new node list
        Map<Node, Node> map = new HashMap<>();

        while (head != null) {
            // copy the current node, then create the same value new node and store it in the map if necessary
            // avoid the multiple copies for the same node
            map.putIfAbsent(head, new Node(head.val));

            // connect the copied node to the new deep copy node list
            // the current pointer has been already copied
            currNode.next = map.get(head);

            // copy the random node if necessary
            if (head.random != null) {
                map.putIfAbsent(head.random, new Node(head.random.val));
            }

            // connect the random node
            currNode.next.random = map.get(head.random);

            head = head.next;
            currNode = currNode.next;
        }
        return dummyHead.next;
    }
}

/**
 *      Time Complexity: O(n)
 *      Space Complexity: O(n)
 */