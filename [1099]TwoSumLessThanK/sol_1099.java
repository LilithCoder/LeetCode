package LeetCode;

import java.util.Arrays;

public class sol_1099 {
    public int twoSumLessThanK(int[] A, int K) {
        Arrays.sort(A);
        int max = -1;
        int start = 0;
        int end = A.length - 1;
        while (start < end) {
            if (A[start] + A[end] < K) {
                max = Math.max(max, A[start] + A[end]);
                start++;
            } else {
                end--;
            }
        }
        return max;
    }
}
