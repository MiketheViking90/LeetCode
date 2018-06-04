package seventeen.design;

import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

public class Trie {

    public TrieNode root = new TrieNode();

    public void insert(String word) {
        int n = word.length();
        Map<Character, TrieNode> children = root.children;

        for (int i = 0; i < n; i++) {
            char c = word.charAt(i);

            TrieNode t;
            if (children.containsKey(c)) {
                t = children.get(c);
            } else {
                t = new TrieNode(c);
                children.put(c, t);
            }

            children = t.children;

            if (i == n-1) {
                t.isLeaf = true;
            }
        }
    }

    public boolean search(String word) {
        TrieNode node = searchNode(root, word);

        if (node != null && node.isLeaf) {
            return true;
        } else {
            return false;
        }
    }

    private TrieNode searchNode(TrieNode root, String word) {
        Map<Character, TrieNode> children = root.children;

        TrieNode t = null;
        for (char c : word.toCharArray()) {
            if (children.containsKey(c)) {
                t = children.get(c);
                children = t.children;
            } else {
                return null;
            }
        }

        return t;
    }

    @NoArgsConstructor
    class TrieNode {
        char c;
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isLeaf;

        public TrieNode(char c) {
            this.c = c;
        }
    }

    public static void main(String[] args) {
        Trie t = new Trie();
        t.insert("cat");
        t.insert("cait");
        t.insert("city");
        t.insert("snow");

        System.out.println(t.search("cat"));
    }
}
