package algorithms;

import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Trie1 {

    TrieNode root = new TrieNode();

    public void addWord(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            node.children.computeIfAbsent(c, k -> new TrieNode(k));
            node = node.getChild(c);
        }
        node.setLeaf(true);
    }

    public boolean find(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.hasChild(c)) {
                node = node.getChild(c);
            } else {
                return false;
            }
        }
        return node.isLeaf;
    }

    public List<String> search(String prefix) {
        List<String> wordMatches = new ArrayList<>();

        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            if (node.hasChild(c)) {
                node = node.getChild(c);
            } else {
                return wordMatches;
            }
        }
        return wordMatches;
    }

    public class TrieNode {
        private final Map<Character, TrieNode> children = new HashMap<>();
        private final char c;
        @Setter
        boolean isLeaf;

        public TrieNode() {
            c = ' ';
        }

        public TrieNode(char c) {
            this.c = c;
        }

        public boolean hasChild(char c) {
            return children.containsKey(c);
        }

        public TrieNode getChild(char c) {
            return children.get(c);
        }

        public TrieNode addChild(char c) {
            TrieNode node = new TrieNode(c);
            children.put(c, node);
            return node;
        }
    }

}
