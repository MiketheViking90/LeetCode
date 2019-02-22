package eighteen.algo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Trie {

    TrieNode root = new TrieNode();

    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            node._children.computeIfAbsent(c, k -> new TrieNode(k));
            node = node._children.get(c);
        }
        node.setIsTerminal();
    }

    public boolean find(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            node = node.get(c);
            if (node == null) {
                return false;
            }
        }
        return node.isTerminal();
    }

    private class TrieNode {
        char _c;
        boolean _isTerminal = false;
        Map<Character, TrieNode> _children = new HashMap<>();

        public TrieNode() {}

        public TrieNode(char c) {
            this._c = c;
        }

        public boolean isTerminal() {
            return _isTerminal;
        }

        public void setIsTerminal() {
            _isTerminal = true;
        }

        public TrieNode get(char c) {
            return _children.get(c);
        }

        public void put(char c) {
            if (!_children.containsKey(c)) {
                TrieNode next = new TrieNode(c);
                _children.put(c, next);
            }
        }

        public void putAll(List<Character> chars) {
            for (char c : chars) {
                put(c);
            }
        }
    }

    public static Trie makeTrie() {
        Trie root = new Trie();
        root.insert("alpha");
        root.insert("beta");
        root.insert("gamma");
        root.insert("omega");
        return root;
    }

    public static void main(String[] args) {
        Trie root = Trie.makeTrie();
        System.out.println(root.find("alpha"));
    }
}
