package LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class sol_212 {
    class TrieNode {
        private TrieNode[] links;
        private final int R = 26;
        private boolean isEnd;
        private String word;
        public TrieNode() {
            this.links = new TrieNode[R];
            this.isEnd = false;
            this.word = null;
        }
        public boolean containsKey(char ch) {
            return links[ch - 'a'] != null;
        }
        public TrieNode get(char ch) {
            return links[ch - 'a'];
        }
        public void put(char ch, TrieNode node) {
            links[ch - 'a'] = node;
        }
        public void setEnd() {
            isEnd = true;
        }
        public boolean getIsEnd() {
            return this.isEnd;
        }
        public void setWord(String word) {
            this.word = word;
        }
        public String getWord() {
            return this.word;
        }
    }

    class Trie {
        private TrieNode root;
        public Trie(TrieNode root) {
            this.root = root;
        }
        public void insert(String word) {
            TrieNode node = root;
            for (char ch: word.toCharArray()) {
                if (!node.containsKey(ch)) {
                    node.put(ch, new TrieNode());
                }
                node = node.get(ch);
            }
            node.setEnd();
            node.setWord(word);
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        Trie trie = new Trie(root);
        Set<String> result = new HashSet<>();
        for (String word: words) {
            trie.insert(word);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char firstChar = board[i][j];
                if (root.containsKey(firstChar)) {
                    dfs(board, i, j, root, firstChar, result);
                }
            }
        }
        return new ArrayList<>(result);
    }

    public int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public void dfs(char[][] board, int i, int j, TrieNode root, char ch, Set<String> res) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == '#' || !root.containsKey(ch)) {
            return;
        }
        char temp = board[i][j];
        board[i][j] = '#';
        root = root.get(ch);
        // make changes
        if (root.getIsEnd() && root.getWord() != null) {
            res.add(root.getWord());
        }
        // recursion
        for (int [] dir: directions) {
            int nexti = i + dir[0];
            int nextj = j + dir[1];
            if (nexti < 0 || nexti >= board.length || nextj < 0 || nextj >= board[0].length) {
                continue;
            }
            dfs(board, nexti, nextj, root, board[nexti][nextj], res);
        }
        // backtrack
        board[i][j] = temp;
        return;
    }
}
