import java.util.*;

/**
 * Given a non-empty list of words, return the k most frequent elements.
 *
 * Your answer should be sorted by frequency from highest to lowest.
 * If two words have the same frequency, then the word with the lower alphabetical order comes first.
 *
 * Example 1:
 * Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * Output: ["i", "love"]
 * Explanation: "i" and "love" are the two most frequent words.
 *     Note that "i" comes before "love" due to a lower alphabetical order.
 * Example 2:
 * Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
 * Output: ["the", "is", "sunny", "day"]
 * Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
 *     with the number of occurrence being 4, 3, 2 and 1 respectively.
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Input words contain only lowercase letters.
 * Follow up:
 * Try to solve it in O(n log k) time and O(n) extra space.
 */

public class sol_692 {
    // appropriate  application: most used for search for the most k frequent words in the search engine

    // wordComparator
    class wordComparator implements Comparator<Map.Entry<String, Integer>> {
        public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {
            if (a.getValue() != b.getValue()) {
                // descending order
                return b.getValue().compareTo(a.getValue());
            } else {
                //ascending order
                return a.getKey().compareTo(b.getKey());
            }
        }
    }

    public List<String> topKFrequent( String[] words, int k) {
        Map<String, Integer> wordCounts = new HashMap<>();
        List<Map.Entry<String, Integer>> candidates = new ArrayList<>();
        List<String> resultList = new ArrayList<>();

        // counting the frequency of each word using HashMap
        for (String str: words) {
            if (wordCounts.containsKey(str)){
                wordCounts.put(str, wordCounts.get(str) + 1);
            } else {
                wordCounts.put(str, 1);
            }
        }

        // flatten the HashMap to the ArrayList
        for (Map.Entry<String, Integer> wordEntry: wordCounts.entrySet()) {
            candidates.add(wordEntry);
        }

        // sort the ArrayList based on the specific Comparator
        Collections.sort(candidates, new wordComparator());

        // add top k keys to the resultList
        for (int i = 0; i < k; i++) {
            resultList.add(candidates.get(i).getKey());
        }

        return resultList;
    }
}

/**
 * Time Complexity: O(nlog(n))
 * Space Complexity: O(1)
 */
