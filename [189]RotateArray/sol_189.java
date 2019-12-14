package LeetCode;

public class sol_189 {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        if (k < 0) {
            k = k + nums.length;
        }
        // reverse the whole array
        reverseArray(nums, 0, nums.length - 1);
        // reverse the 1st partition we need to reverse
        reverseArray(nums, 0, k - 1);
        // reverse the 2nd partition we need to reverse
        reverseArray(nums, k, nums.length - 1);
    }
    public void reverseArray(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
