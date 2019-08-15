import java.util.*;

/**
 * Given two words (beginWord and endWord), and a dictionary's word list,
 * find the length of shortest transformation sequence from beginWord to endWord, such that:
 *
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 * Note:
 *
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 * Example 1:
 *
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * Output: 5
 *
 * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * Example 2:
 *
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 *
 * Output: 0
 *
 * Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 */

public class sol_127 {
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        // add all words from wordList into dict in order to use contains() method
        Set<String> dict = new HashSet<>();
        for (String word : wordList) {
            dict.add(word);
        }

        if (beginWord.equals(endWord)) {
            return 1;
        }

        Set<String> list = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        int lengthOfList = 1;

        list.add(beginWord);
        queue.add(beginWord);

        while (!queue.isEmpty()) {
            lengthOfList++;

            // the size of queue must be initialized in advance
            // since the size of queue might be modified inside the loop
            int lengthOfQueue = queue.size();
            for (int index = 0; index < lengthOfQueue; index++) {
                String topWord = queue.poll();

                // find the next word of the topWord from dictionary
                // AND add it to the queue
                for (int i = 0; i < topWord.length(); i++) {
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        if (ch == topWord.charAt(i)) {
                            continue;
                        }

                        char[] charArr = topWord.toCharArray();
                        charArr[i] = ch;
                        String changedStr = String.valueOf(charArr);

                        if (dict.contains(changedStr)) {
                            if (list.contains(changedStr)) {
                                continue;
                            }

                            if (changedStr.equals(endWord)) {
                                return lengthOfList;
                            }
                            queue.add(changedStr);
                            list.add(changedStr);
                        }
                    }
                }
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("hot");
        list.add("dot");
        list.add("dog");
        list.add("lot");
        list.add("log");
        list.add("cog");

        System.out.println(ladderLength("hit", "cog", list));
    }
}
