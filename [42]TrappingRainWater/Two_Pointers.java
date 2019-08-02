public class Two_Pointers {
    public int trap(int[] height) {
        int res = 0;
        int leftMax = 0;
        int rightMax = 0;
        int rightIndex = height.length - 1;
        int leftIndex = 0;
        while (leftIndex < rightIndex) {
            if (height[leftIndex] < height[rightIndex]) {
                leftMax = Math.max(leftMax, height[leftIndex]);
                res += leftMax - height[leftIndex];
                leftIndex++;
            } else {
                rightMax = Math.max(rightMax, height[rightIndex]);
                res += rightMax - height[rightIndex];
                rightIndex--;
            }
        }
        return res;
    }
}
