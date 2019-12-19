package LeetCode;

public class sol_28 {
    public int strStr(String haystack, String needle) {
        // https://www.youtube.com/watch?v=BXCEFAzhxGY
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if (j == needle.length()) return i;
                if (i + j == haystack.length()) return -1;
                if (needle.charAt(j) != haystack.charAt(i + j)) break;
            }
        }
    }
}
