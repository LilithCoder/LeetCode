import java.lang.reflect.Array;
import java.util.*;

/**
 * Given two words (beginWord and endWord), and a dictionary's word list,
 * find all shortest transformation sequence(s) from beginWord to endWord, such that:
 *
 * Only one letter can be changed at a time
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 * Note:
 *
 * Return an empty list if there is no such transformation sequence.
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
 * Output:
 * [
 *   ["hit","hot","dot","dog","cog"],
 *   ["hit","hot","lot","log","cog"]
 * ]
 * Example 2:
 *
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 *
 * Output: []
 *
 * Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 */


public class sol_126 {
    // use BFS to construct tree and use DFS to find all appropriate paths
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();

        // Store all the neighbour nodes of each node
        Map<String, List<String>> neighbourNodes = new HashMap<>();

        // Store Each node's distance from the beginWord
        Map<String, Integer> distance = new HashMap<>();
        Set<String> dictStr = new HashSet<>();

        // store the current path in DFS which is ready to be output
        List<String> path = new ArrayList<>();

        for (String word: wordList) {
            dictStr.add(word);
        }

        dictStr.add(beginWord);
        bfs(beginWord, endWord, dictStr, neighbourNodes, distance);
        dfs(beginWord, endWord, neighbourNodes, distance, result, path);

        return result;
    }

    // BFS: construct the binary tree, and store distance of each node from the start node (level by level)
    private void bfs(String beginWord, String endWord, Set<String> dictStr, Map<String, List<String>> neighbourNodes, Map<String, Integer> distance) {
        for (String str: dictStr) {
            neighbourNodes.putIfAbsent(str, new ArrayList<>());
        }

        Queue<String> queue = new LinkedList();
        queue.add(beginWord);
        distance.put(beginWord, 0);

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean isFoundEnd = false;

            // handle the current level nodes
            for (int i = 0; i < size; i++) {
                String currWord = queue.poll();
                int currentDistance = distance.get(currWord);

                // find all the neighbour nodes of the current node
                for (int j = 0; j < currWord.length(); j++) {
                    for (char ch= 'a'; ch <= 'z'; ch++) {
                        if (ch == currWord.charAt(j)) {
                            continue;
                        }
                        char[] charArr = currWord.toCharArray();
                        charArr[j] = ch;
                        String changedStr = String.valueOf(charArr);

                        if (dictStr.contains(changedStr)) {
                            neighbourNodes.get(currWord).add(changedStr);
                        }
                    }
                }

                // traverse all the neighbour nodes of the current node
                // AND then store their distance into HashMap
                // all the repeated nodes will in the tree will not be added into distance
                for (String neighbour: neighbourNodes.get(currWord)) {
                    if (!distance.containsKey(neighbour)) {
                        distance.put(neighbour,currentDistance + 1);
                        if (neighbour.equals(endWord)) {
                            isFoundEnd = true;
                        } else {
                            queue.add(neighbour);
                        }
                    }
                }
            }
            // Once the endWord is found, break out
            // In one current Level, there might be multiple nodes whose neighbour is endWord
            // So after traverse all the neighbours of all the node in this current level,
            // then break out
            if (isFoundEnd == true) break;
        }
    }

    // DFS: DFS all the words which is stored in distance and store them in path temporarily
    // then backtracking and find all other paths in the tree which is constructed by BFS
    private void dfs(String currWord, String endWord, Map<String, List<String>> neighbourNodes, Map<String, Integer> distance, List<List<String>> result, List<String> path) {
        path.add(currWord);
        if (currWord.equals(endWord)) {
            result.add(new ArrayList<>(path));
        } else {
            for (String nextWord: neighbourNodes.get(currWord)) {
                if (distance.get(nextWord) == distance.get(currWord) + 1) {
                    dfs(nextWord, endWord, neighbourNodes, distance, result, path);
                }
            }
        }

        // backtracking: every time come back to the upper-level recursion,
        // delete the last word of this path until find another available neighbour
        path.remove(path.size() - 1);
    }
}
























