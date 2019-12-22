package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class sol_560 {
    public int subarraySum(int[] nums, int k) {
        // https://www.youtube.com/watch?v=aYfwus5T3Bs
        if (nums == null || nums.length == 0) return 0;
        Map<Integer, Integer> sums = new HashMap<>();
        sums.put(0, 1);
        int prefixSum = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            count += sums.getOrDefault(prefixSum - k, 0);
            sums.put(prefixSum, sums.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }
}
