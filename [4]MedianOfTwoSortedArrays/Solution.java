public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //Time Complexity: O(log(min(m,n)))

        //binary search on the first array

        //To make sure the length of nums1 is less than or equal to nums2, switch two array if that is the case
        if(nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int firstLength = nums1.length;
        int secondLength = nums2.length;

        int start = 0;
        int end = firstLength;

        boolean isEven = ((firstLength + secondLength) % 2 == 0) ? true : false;



        while(start <= end){
            int partition1 = (start + end) / 2;
            int partition2 = (firstLength + secondLength + 1) / 2 - partition1;
            int maxLeftnums1 = (partition1 == 0) ? Integer.MIN_VALUE : nums1[partition1 - 1];
            int minRightnums1 = (partition1 == firstLength) ? Integer.MAX_VALUE : nums1[partition1];

            int maxLeftnums2 = (partition2 == 0) ? Integer.MIN_VALUE : nums2[partition2 - 1];
            int minRightnums2 = (partition2 == secondLength) ? Integer.MAX_VALUE : nums2[partition2];

            if(maxLeftnums1 <= minRightnums2 && maxLeftnums2 <= minRightnums1){
                if(isEven){
                    return (double) (Math.max(maxLeftnums1, maxLeftnums2) + Math.min(minRightnums1, minRightnums2)) / 2;
                } else {
                    return (double) Math.max(maxLeftnums1, maxLeftnums2);
                }
            } else if(maxLeftnums1 > minRightnums2) {
                // partition of the array nums1 is too right
                end = partition1 - 1;
            } else if(maxLeftnums2 > minRightnums1) {
                // partition of the array nums1 is too left
                start = partition1 + 1;
            }

        }

        throw new IllegalArgumentException();

    }
}
