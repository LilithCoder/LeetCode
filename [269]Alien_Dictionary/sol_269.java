import java.util.*;

/**
 * There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you. You receive a list of non-empty words from the dictionary, where words are sorted lexicographically by the rules of this new language. Derive the order of letters in this language.
 *
 * Example 1:
 *
 * Input:
 * [
 *   "wrt",
 *   "wrf",
 *   "er",
 *   "ett",
 *   "rftt"
 * ]
 *
 * Output: "wertf"
 * Example 2:
 *
 * Input:
 * [
 *   "z",
 *   "x"
 * ]
 *
 * Output: "zx"
 * Example 3:
 *
 * Input:
 * [
 *   "z",
 *   "x",
 *   "z"
 * ]
 *
 * Output: ""
 *
 * Explanation: The order is invalid, so return "".
 * Note:
 *
 * You may assume all letters are in lowercase.
 * You may assume that if a is a prefix of b, then a must appear before b in the given dictionary.
 * If the order is invalid, return an empty string.
 * There may be multiple valid order of letters, return any one of them is fine.
 * */

public class sol_269 {
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        int[] inDegree = new int[26];
        buildGraph(graph, inDegree, words);
        return bfs(graph, inDegree);
    }

    private void buildGraph(Map<Character, Set<Character>> graph, int[] inDegree, String[] words) {

        for (String wordStr: words) {
            for (char wordChar: wordStr.toCharArray()) {
                /**
                 * putIfAbsent?(K key, V value):
                 * This method If the specified key is not already associated with a value
                 * (or is mapped to null) associates it with the given value and returns null,
                 * else returns the current value.
                 */
                graph.putIfAbsent(wordChar, new HashSet<>());
            }
        }

        for (int i = 1; i < words.length; i++) {
            String beforeStr = words[i - 1];
            String afterStr = words[i];
            int lengthOfStr = Math.min(beforeStr.length(), afterStr.length());
            for(int j = 0; j < lengthOfStr; j++) {
                char out = beforeStr.charAt(j);
                char in = afterStr.charAt(j);
                if (out != in) {
                    if (!graph.get(out).contains(in)) {
                        graph.get(out).add(in);
                        inDegree[in - 'a']++;
                    }
                    break;
                }
            }
        }
    }

    private String bfs(Map<Character, Set<Character>> graph, int[] inDegree) {
        StringBuilder sb = new StringBuilder();
        Queue<Character> queue = new LinkedList<>();
        for (char ch: graph.keySet()) {
            if (inDegree[ch - 'a'] == 0) {
                queue.offer(ch);
            }
        }

        while (!queue.isEmpty()) {
            char out = queue.poll();
            sb.append(out);
            for (char in: graph.get(out)) {
                inDegree[in - 'a']--;
                if (inDegree[in - 'a'] == 0) {
                    queue.offer(in);
                }
            }
        }
        if (sb.length() == graph.size()) {
            return String.valueOf(sb);
        } else {
            return "";
        }
    }
}























