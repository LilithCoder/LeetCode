package LeetCode;

public class sol_283 {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int read = 0;
        int write = 0;
        // when meet with 0, shift the non-0 number to left
        while (read <= nums.length - 1) {
            if (nums[read] == 0) {
                read++;
            } else if (nums[read] != 0) {
                nums[write] = nums[read];
                write++;
                read++;
            }
        }
        // change the remaining right number to 0
        while (write <= nums.length - 1) {
            nums[write] = 0;
            write++;
        }
    }
}
