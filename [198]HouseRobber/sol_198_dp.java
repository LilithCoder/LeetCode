public class sol_198_dp {
    // when using bottom-up solving pattern, then use dp
    // when one house, two house, three house...
    // when something comes with adjacent, then dp
    // when come with the current house, two situation: 1. rob this house 2. not rob this house
    public int rob(int[] nums) {
        // error checking
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // at least three elements assuming in the dp section
        // so check the case when the # of elements is one or two first
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        // dp[i] indicate the maximum amount of money has been robbed
        // when comes to the ith house
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }
        return dp[nums.length - 1];
    }
}
