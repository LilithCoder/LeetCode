package LeetCode;

import java.util.HashSet;
import java.util.Set;

public class sol_681 {
    public String nextClosestTime(String time) {
        int minutes = Integer.parseInt(time.substring(0, 2)) * 60 + Integer.parseInt(time.substring(3));
        Set<Integer> digits = new HashSet<>();
        for (char c: time.toCharArray()) {
            if (c != ':') {
                digits.add(c - '0');
            }
        }
        while (true) {
            // if the current time is 23:59, then the next time should be 00:00
            minutes = (minutes + 1) % (24 * 60);
            int[] nextTime = { minutes / 60 / 10, minutes / 60 % 10, minutes % 60 / 10, minutes % 60 % 10 };
            boolean isValid = true;
            for (int digit: nextTime) {
                if (!digits.contains(digit)) {
                    isValid = false;
                }
            }
            if (isValid) {
                // The %02d means: "Format as a decimal number using at least 2 digits, and pad with 0 if less than 2 digits"
                return String.format("%02d:%02d", minutes / 60, minutes % 60);
            }
        }
    }
}
