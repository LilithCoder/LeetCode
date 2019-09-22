import java.util.*;

/**
 * 最小堆
 * 因为最终需要返回前 k 个频率最大的元素，通过维护一个元素数目为 k 的最小堆，
 * 每次都将新的元素与堆顶端的元素（堆中频率最小的元素）进行比较，
 * 如果新的元素的频率比堆顶端的元素大，则弹出堆顶端的元素，将新的元素添加进堆中。
 * 最终，堆中的 k 个元素即为前 k 个高频元素。
 */

public class sol_347_hashmap_priorityqueue {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<HashMap.Entry<Integer, Integer>> pqueue = new PriorityQueue<>(new Comparator<HashMap.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2) {
                return e1.getValue() - e2.getValue();
            }
        });
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (pqueue.size() < k) {
                pqueue.add(entry);

            } else if (entry.getValue() > pqueue.peek().getValue()){
                pqueue.remove();
                pqueue.add(entry);
            }
        }
        for (Map.Entry<Integer, Integer> entry: pqueue) {
            result.add(entry.getKey());
        }
        return result;
    }
}
