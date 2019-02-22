package eighteen.algo;

import java.util.HashMap;
import java.util.Map;

class MapSum {

    Map<String, Integer> vals = new HashMap<>();


    public MapSum() {

    }

    public void insert(String key, int val) {
        vals.put(key, val);
    }

    public int sum(String prefix) {
        return 0;
    }

    public static void main(String[] args) {

    }

    class Trie {
        TrieNode root = new TrieNode();

        public void addWord(String word) {

        }
    }

    class TrieNode {
        char c;
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isTerminal = false;

        public TrieNode(char c) {
            this.c = c;
        }

        public void addLetter(char c) {
            if (!children.containsKey(c)) {
                children.put(c, new TrieNode(c));
            }
        }

        public void markTerminal() {
            this.isTerminal = true;
        }
    }

}