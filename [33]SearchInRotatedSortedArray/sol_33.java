package LeetCode;

public class sol_33 {
    // If we look at the array in the example closely, we notice that at least one half of the array is always sorted.
    // We can use this property to our advantage.
    // If the number n lies within the sorted half of the array,
    // then our problem is a basic binary search.
    // Otherwise discard the sorted half and keep examining the unsorted half.
    // Since we are partitioning the array in half at each step this gives us O(logn) runtime complexity.
    public static int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        return modifiedBinarySearchHelper(start, end, nums, target);
    }

    public static int modifiedBinarySearchHelper(int start, int end, int[] nums, int target) {
        if (start > end) return -1;
        int mid = (start + end) / 2;
        if (nums[mid] == target) {
            return mid;
        }
        if (nums[start] <= nums[mid] && (target <= nums[mid] && target >= nums[start])) {
            // end = mid - 1;
            return modifiedBinarySearchHelper(start, mid - 1, nums, target);
        } else if (nums[mid] <= nums[end] && (target >= nums[mid] && target <= nums[end])) {
            // start = mid + 1;
            return modifiedBinarySearchHelper(mid + 1, end, nums, target);
        } else if (nums[end] <= nums[mid]) {
            // start = mid + 1;
            return modifiedBinarySearchHelper(mid + 1, end, nums, target);
        } else if (nums[start] >= nums[mid]) {
            // end = mid - 1;
            return modifiedBinarySearchHelper(start, mid - 1, nums, target);
        }
        return -1;
    }

    public static void main(String []args){
        int[] nums = {4,5,6,7,0,1,2,3};
        int target = 3;
        System.out.println(search(nums, target));
    }
}
