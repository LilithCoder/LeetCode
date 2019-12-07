package LeetCode;

public class sol_66 {
    // solution: https://www.youtube.com/watch?v=_sls9AdBymI
    public int[] plusOne(int[] digits) {
        // traverse the digits from end to start, if the digit is 9, then change the digit to zero, otherwise just increment 1 and return the array
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            } else {
                digits[i] = 0;
            }
        }

        // if the integer is like 9, 99, 999
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }
}
