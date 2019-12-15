package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class sol_992 {
    public int subarraysWithKDistinct(int[] A, int K) {
        return subarraysWithAtMostKDistinct(A, K) - subarraysWithAtMostKDistinct(A, K - 1);
    }
    public int subarraysWithAtMostKDistinct(int[] A, int K) {
        int result = 0;
        int start = 0;
        int end = 0;
        // used to count the number of occurrence of each integer of the sliding window
        // use hashmap to keep the number of unique integer of sliding window less or equal than K
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        // sliding window
        while (end < A.length) {
            map.put(A[end], map.getOrDefault(A[end], 0) + 1);
            while (map.size() > K) {
                map.put(A[start], map.get(A[start]) - 1);
                if (map.get(A[start]) == 0) {
                    map.remove(A[start]);
                }
                start++;
            }
            // increment the count of consecutive arrays (subarrays) of each sliding window
            count += end - start + 1;
            end++;
        }
        return count;
    }
}
