package LeetCode;

public class sol_88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int tail1 = m - 1;
        int tail2 = n - 1;
        int mergedTail = m + n - 1;
        while (tail1 >= 0 && tail2 >= 0) {
            nums1[mergedTail--] = nums1[tail1] > nums2[tail2] ? nums1[tail1--] : nums2[tail2--];
        }
        // if nums1 has remaining, just do nothing since the remaining has already been in the nums1 and sorted
        // if nums2 has remainging, merge the remaining small number into nums1
        while (tail2 >= 0) {
            nums1[mergedTail--] = nums2[tail2--];
        }
    }
}
