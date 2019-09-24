public class sol_11_twoPointers {
    public int maxArea(int[] height) {
        // two-pointer solution
        int max = Integer.MIN_VALUE;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            if (height[left] < height[right]) {
                max = Math.max(max, height[left] * (right - left));
                left++;
            } else {
                max = Math.max(max, height[right] * (right - left));
                right--;
            }
        }
        return max;
    }
}
