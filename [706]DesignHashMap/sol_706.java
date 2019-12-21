package LeetCode;

public class sol_706 {
    // https://leetcode.com/problems/design-hashmap/discuss/227081/Java-Solutions
    class ListNode {
        int key;
        int val;
        ListNode next;
        ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    final ListNode[] nodes = new ListNode[10000];

    /** Initialize your data structure here. */
//    public MyHashMap() {
//
//    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = indexOf(key);
        ListNode prev = findElement(index, key);
        // the reason we use dummy head (-1, -1) is right here
        // we need to avoid throwing a NullPointerException
        if (prev.next == null) {
            // when key does not exist
            prev.next = new ListNode(key, value);
        } else {
            // when key does exist
            prev.next.val = value;
        }
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = indexOf(key);
        ListNode prev = findElement(index, key);
        return prev.next == null ? -1 : prev.next.val;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = indexOf(key);
        ListNode prev = findElement(index, key);
        // find that key in the LinkedList
        if (prev.next != null) {
            prev.next = prev.next.next;
        }
    }

    public int indexOf(int key) {
        return Integer.hashCode(key) % nodes.length;
    }
    public ListNode findElement(int index, int key) {
        if (nodes[index] == null) {
            // dummy head (-1, -1)
            return nodes[index] = new ListNode(-1, -1);
        }
        // Using the prev node in find method to avoid corner cases
        ListNode prev = nodes[index];
        while (prev.next != null && prev.next.key != key) {
            prev = prev.next;
        }
        return prev;
    }
}
