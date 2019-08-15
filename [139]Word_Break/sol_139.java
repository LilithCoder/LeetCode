import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
 * determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 *
 * Note:
 *
 * The same word in the dictionary may be reused multiple times in the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 * Example 1:
 *
 * Input: s = "leetcode", wordDict = ["leet", "code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 * Example 2:
 *
 * Input: s = "applepenapple", wordDict = ["apple", "pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 *              Note that you are allowed to reuse a dictionary word.
 * Example 3:
 *
 * Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output: false
 */

public class sol_139 {
    public boolean wordBreak(String s, List<String> wordDict) {

        // use hashset to store the words from dict
        // in order to use contains() method time-efficiently
        Set<String> dict = new HashSet<>();
        for (String word: wordDict) {
            dict.add(word);
        }

        // the state of dp refers to whether the substring before the segment location
        // could be divided to one or multiple valid words
        boolean[] dp = new boolean[s.length() + 1];

        // base case
        dp[0] = true;

        // dynamic programming
        for (int i = 1; i <= s.length(); i++) {
            for(int j = 0; j < i; j++) {
                dp[i] = dp[j] && dict.contains(s.substring(j, i));
                if (dp[i]) {
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
