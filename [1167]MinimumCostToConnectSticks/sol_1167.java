package LeetCode;

import java.util.PriorityQueue;

public class sol_1167 {
    public int connectSticks(int[] sticks) {
        int result = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int stick: sticks) {
            minHeap.add(stick);
        }
        while (minHeap.size() > 1) {
            // every time connect one stick then put it back to minHeap
            int sum = minHeap.poll() + minHeap.poll();
            minHeap.add(sum);
            result += sum;
        }
        return result;
    }
}
