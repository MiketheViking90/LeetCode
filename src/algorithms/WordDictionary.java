package algorithms;

import java.util.HashMap;
import java.util.Map;

public class WordDictionary {

    TrieNode root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        char[] cAry = word.toCharArray();
        TrieNode node = root;
        for (char c : cAry) {
            if (node.children.containsKey(c)) {
                node = node.children.get(c);
            } else {
                node.children.computeIfAbsent(c, k ->new TrieNode(c));
            }
        }
        node.setLeaf(true);
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        char[] cAry = word.toCharArray();
        TrieNode node = root;
        for (char c : cAry) {
            if (node.children.containsKey(c)) {
                node = node.children.get(c);
            } else {
                return false;
            }
        }
        return node.isLeaf;
    }

    private class TrieNode {
        private boolean isLeaf = false;
        private char c;
        private Map<Character, TrieNode> children = new HashMap<>();

        TrieNode() {}

        TrieNode(char c) {
            this.c = c;
        }

        public void setLeaf(boolean b) {
            this.isLeaf = b;
        }
    }

    public static void main(String[] args) {
        WordDictionary wd = new WordDictionary();
        wd.addWord("bad");
        wd.addWord("dad");
        wd.addWord("mad");
        wd.addWord("pad");

        System.out.println(wd.search("bad"));
        System.out.println(wd.search(".ad"));
        System.out.println(wd.search("b.."));
    }
}
