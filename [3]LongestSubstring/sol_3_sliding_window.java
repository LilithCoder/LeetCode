package LeetCode;

import java.util.HashSet;
import java.util.Set;

public class sol_3_sliding_window {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        Set<Character> set = new HashSet<>();
        int start = 0;
        int end = 0;
        // sliding window
        while (start < s.length() && end < s.length()) {
            if (set.contains(s.charAt(end))) {
                set.remove(s.charAt(start));
                start++;
            } else {
                set.add(s.charAt(end));
                result = Math.max(result, end - start + 1);
                end++;
            }
        }
        return result;
    }
}
