package LeetCode;

import java.util.PriorityQueue;

public class KthLargest {
    private PriorityQueue<Integer> maxHeap;
    private int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.maxHeap = new PriorityQueue<>();
        // build a minHeap which contains k largest elements
        for (int num: nums) {
            if (maxHeap.size() < this.k) {
                maxHeap.add(num);
            } else if (num > maxHeap.peek()) {
                maxHeap.remove();
                maxHeap.add(num);
            }

        }
    }

    public int add(int val) {
        if (maxHeap.size() < this.k) {
            maxHeap.add(val);
        } else if (val > maxHeap.peek()) {
            maxHeap.remove();
            maxHeap.add(val);
        }
        return maxHeap.peek();
    }
    // 2 4 5 8
    // 2 3 4 5 8->4
    // 2 3 4 5 5 8->5
    // 2 3 4 5 5 8 10->5
    // 2 3 4 5 5 8 10 9->8
    // 2 3 4 4 5 5 8 10 9->8
}