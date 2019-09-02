public class sol_53_dp {
    public int maxSubArray(int[] nums) {
        // Time Complexity: O(n)
        // Space Complexity: O(n)
        // each item of this array means
        // the maximum sum of the sub-array which ends in the current index
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        // check whether the value of current problem or the value of current problems plus the value of previous sub-problem is bigger
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
    public int maxSubArray_1(int[] nums) {
        // Time Complexity: O(n)
        // Space Complexity: O(1) we only need to know the value of the current problem and the value of previous sub-problem
        int a = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int b = Math.max(a + nums[i], nums[i]);
            max = Math.max(max, b);
            a = b;
        }
        return max;
    }
}
