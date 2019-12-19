package LeetCode;

import java.util.PriorityQueue;

public class sol_1046 {
    public int lastStoneWeight(int[] stones) {
        // greedy solution use maxheap, similar to lc[1167]Minimum Cost to Connect Sticks
        if (stones == null || stones.length == 0) return 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int stone: stones) {
            maxHeap.add(stone);
        }
        while (maxHeap.size() >= 1) {
            if (maxHeap.size() == 1) return maxHeap.poll();
            int newStone = Math.abs(maxHeap.poll() - maxHeap.poll());
            maxHeap.add(newStone);
        }
        return 0;
    }
}
