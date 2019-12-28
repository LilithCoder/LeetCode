package LeetCode;

public class sol_9 {
    public boolean isPalindrome(int x) {
        // corner case
        // if x is negative or the last digit of x is 0
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }
        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x = x / 10;
        }
        // 12321 12 == 123/10
        // 1221  12 == 21
        return x == revertedNumber || x == revertedNumber / 10;
    }
}
