package LeetCode;

public class sol_905 {
    public int[] sortArrayByParity(int[] A) {
        int indexForEven = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                int temp = A[indexForEven];
                A[indexForEven] = A[i];
                A[i] = temp;
                indexForEven++;
            }
        }
        return A;
    }
}
