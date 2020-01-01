package LeetCode;

import java.util.*;

public class sol_472 {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> result = new ArrayList<>();
        Set<String> previousWords = new HashSet<>();
        // Arrays.sort(words, new Comparator<String>() {
        //     public int compare(String s1, String s2) {
        //         return s1.length() - s2.length();
        //     }
        // });
        Arrays.sort(words, (s1, s2) -> s1.length() - s2.length());
        for (int i = 0; i < words.length; i++) {
            if (canForm(words[i], previousWords)) {
                result.add(words[i]);
            }
            previousWords.add(words[i]);
        }
        return result;
    }
    public boolean canForm(String word, Set<String> previousWords) {
        if (previousWords.isEmpty()) {
            return false;
        }
        // whether the substring(0, end) can be a concatenated word
        boolean[] dp = new boolean[word.length() + 1];
        dp[0] = true;
        for (int end = 1; end <= word.length(); end++) {
            for (int start = 0; start < end; start++) {
                if (!dp[start]) {
                    continue;
                }
                if (previousWords.contains(word.substring(start, end))) {
                    dp[end] = true;
                    break;
                }
            }
        }
        return dp[word.length()];
    }
}
