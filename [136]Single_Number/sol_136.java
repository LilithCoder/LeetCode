import java.util.HashSet;
import java.util.Set;

public class sol_136 {
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num: nums) {
            if (set.contains(num)) {
                set.remove(num);
            } else {
                set.add(num);
            }
        }
        for (int num: set) {
            return num;
        }
        return -1;
    }
    /**
     * Exclusive OR
     * use bitwise XOR to solve this problem
     * bitwise XOR in java
     *
     * 0 ^ N = N
     * N ^ N = 0
     *
     * 1 ^ 1 = 0
     * 1 ^ 0 = 1
     * if same, 0
     * if not same, 1
     */
    public int singleNumber1(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }
}