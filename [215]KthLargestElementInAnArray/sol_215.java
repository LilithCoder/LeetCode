package LeetCode;

import java.util.PriorityQueue;

public class sol_215 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((a, b) -> a - b);
        for (int num: nums) {
            minHeap.add(num);
            // keep the size of heap is k
            // k smallest elements
            // the final element will the kth largest element
            if (minHeap.size() > k) {
                minHeap.remove();
            }
        }
        return minHeap.poll();
    }
}
