package LeetCode;

public class sol_208 {
    class TrieNode {
        // R links to node children
        private TrieNode[] links;
        private final int R = 26;
        private boolean isEnd;
        public TrieNode() {
            links = new TrieNode[R];
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
        public boolean isEnd() {
            return isEnd;
        }
    }

    class Trie {
        private TrieNode root;

        /** Initialize your data structure here. */
        public Trie() {
            root = new TrieNode();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            TrieNode node = root;
            for (char ch: word.toCharArray()) {
                if (!node.containsKey(ch)) {
                    node.put(ch, new TrieNode());
                }
                node = node.get(ch);
            }
            node.setEnd();
        }

        /** Returns if the word is in the trie. */
        // exactly 'leet'
        public boolean search(String word) {
            TrieNode node = searchPrefix(word);
            return node != null && node.isEnd();
        }

        public TrieNode searchPrefix(String word) {
            TrieNode node = root;
            for (char ch: word.toCharArray()) {
                if (node.containsKey(ch)) {
                    node = node.get(ch);
                } else {
                    return null;
                }
            }
            return node;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        // could be 'leetcode'
        public boolean startsWith(String prefix) {
            TrieNode node = searchPrefix(prefix);
            return node != null;
        }
    }
}
