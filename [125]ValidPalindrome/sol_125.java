package LeetCode;

public class sol_125 {
    public boolean isPalindrome(String s) {
        if (s == null) return true;
        int left = 0;
        int right = s.length() - 1;
        // two pointer
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left += 1;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right -= 1;
            }
            if (left < right && Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
