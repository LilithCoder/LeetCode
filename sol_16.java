package LeetCode;

import java.util.Arrays;

public class sol_16 {
    public int threeSumClosest(int[] nums, int target) {
        // three pointers while loop within for loop
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[nums.length - 1];
        for (int firstPointer = 0; firstPointer < nums.length - 2; firstPointer++) {
            int secondPointer = firstPointer + 1;
            int thirdPointer = nums.length - 1;
            while (secondPointer < thirdPointer) {
                int sum = nums[firstPointer] + nums[secondPointer] + nums[thirdPointer];
                if (sum > target) {
                    thirdPointer--;
                } else if (sum < target) {
                    secondPointer++;
                } else {
                    return sum;
                }
                if (Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum;
                }
            }
        }
        return result;
    }
}
