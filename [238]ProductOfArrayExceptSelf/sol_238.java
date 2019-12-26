package LeetCode;

public class sol_238 {
    public int[] productExceptSelf(int[] nums) {
        // Please solve it without division and in O(n).
        int[] result = new int[nums.length];
        // calculate the left side product of array elements except for the ith element
        int left = 1;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0) {
                left = left * nums[i - 1];
            }
            result[i] = left;
        }
        // calculate the right side product of array elements except for the ith element
        int right = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i < nums.length - 1) {
                right = right * nums[i + 1];
            }
            result[i] *= right;
        }
        return result;
    }
}
