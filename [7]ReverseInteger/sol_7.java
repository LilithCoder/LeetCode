package LeetCode;

public class sol_7 {
    public int reverse(int x) {
        long reversedNumber = 0;
        if (x % 10 == 0) x = x / 10;
        while (x != 0) {
            reversedNumber = reversedNumber * 10 + x % 10;
            x = x / 10;
        }
        if (reversedNumber < Integer.MIN_VALUE || reversedNumber > Integer.MAX_VALUE) {
            return 0;
        } else {
            return (int) reversedNumber;
        }
    }
}
