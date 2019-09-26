package LeetCode;

public class sol_152_dp {
    public int maxProduct(int[] nums) {
        // error checking
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int currentMax = nums[0];
        int currentMin = nums[0];
        int finalMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int tempCurrentMax = currentMax;
            currentMax = Math.max(Math.max(currentMax * nums[i], currentMin * nums[i]), nums[i]);
            currentMin = Math.min(Math.min(tempCurrentMax * nums[i], currentMin * nums[i]), nums[i]);
            finalMax = Math.max(currentMax, finalMax);
        }
        return finalMax;
    }
}
