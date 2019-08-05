import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//        Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
//        Find all unique triplets in the array which gives the sum of zero.
//
//        Note:
//
//        The solution set must not contain duplicate triplets.
//
//        Example:
//
//        Given array nums = [-1, 0, 1, 2, -1, -4],
//
//        A solution set is:
//        [
//        [-1, 0, 1],
//        [-1, -1, 2]
//        ]

//        The continue statement breaks one iteration (in the loop),
//        if a specified condition occurs, and continues with the next iteration in the loop.



public class Sol_3Sum {
    public List<List<Integer>> threeSum(int[] nums) {

        ArrayList<List<Integer>> list = new ArrayList<>();

        if (nums == null && nums.length < 3) {
            return list;
        }

//      O(nlogn)
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int leftPointer = i + 1;
            int rightPointer = nums.length - 1;

            while (leftPointer < rightPointer) {

                int sum = nums[i] + nums[leftPointer] + nums[rightPointer];

                if (sum == 0) {
                    List<Integer> threeSum = new ArrayList<>();
                    threeSum.add(nums[i]);
                    threeSum.add(nums[leftPointer]);
                    threeSum.add(nums[rightPointer]);
                    list.add(threeSum);
                    leftPointer++;
                    rightPointer--;

                    while (leftPointer < rightPointer && nums[leftPointer] == nums[leftPointer - 1]) {
                        leftPointer++;
                    }

                    while (leftPointer < rightPointer && nums[rightPointer] == nums[rightPointer + 1]) {
                        rightPointer--;
                    }
                } else if (sum > 0) {
                    rightPointer--;
                } else {
                    leftPointer++;
                }
            }
        }
        return list;
    }
}
