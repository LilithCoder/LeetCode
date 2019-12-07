package LeetCode;

public class sol_242 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        // only contains 26 lowercase letters
        int[] counts = new int[26];

        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
            counts[t.charAt(i) - 'a']--;
        }

        // make the all elements of counts are 0
        for (int count: counts) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
}
