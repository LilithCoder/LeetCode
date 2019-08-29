import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class sol_819 {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedWords = new HashSet<>();
        for (String bannedStr: banned) {
            bannedWords.add(bannedStr);
        }
        Map<String, Integer> wordCounts = new HashMap<>();

        // remove all non-letter character and transform to lowercase, then split them to individual words
        for (String word: paragraph.replaceAll("[^a-zA-Z]", " ").toLowerCase().split(" ")) {
            if (!bannedWords.contains(word)) {
                wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
            }
        }

        // find the word with the largest count
        String result = "";
        for (String word: wordCounts.keySet()) {
            if (result.equals("") ||  wordCounts.get(word) > wordCounts.get(result)) {
                result = word;
            }
        }
        return result;
    }
}
