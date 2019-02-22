package eighteen.algo;

import java.util.HashMap;
import java.util.Map;

class MapSum {

    Map<String, Integer> vals = new HashMap<>();
    SumTrie trie = new SumTrie();

    public MapSum() {

    }

    public void insert(String key, int val) {
        vals.put(key, val);
        trie.insert(key);
    }

    public int sum(String prefix) {
        return trie.sum(prefix);
    }

    class SumTrie {
        private SumTrieNode root = new SumTrieNode();

        public void insert(String word) {
            SumTrieNode node = root;
            for (char c : word.toCharArray()) {
                node.put(c);
                node = node.getChild(c);
            }
            node.isTerminal = true;
        }

        public int sum(String prefix) {
            int sum = 0;
            SumTrieNode node = root;
            int N = prefix.length();
            for (int i = 0; i < N; i++) {
                node = node.getChild(prefix.charAt(i));
                if (node == null) {
                    return 0;
                }
            }
            return sum + getSum(node, prefix);
        }

        private int getSum(SumTrieNode root, String word) {
            int curSum = 0;

            if (root.isTerminal) {
                curSum += vals.get(word);
            }
            for (SumTrieNode child : root.children.values()) {
                curSum += getSum(child, word + child.c);
            }
            return curSum;
        }

        class SumTrieNode {
            char c;
            boolean isTerminal = false;
            Map<Character, SumTrieNode> children = new HashMap<>();

            public SumTrieNode(char c) {
                this.c = c;
            }

            public SumTrieNode() {}

            public void put(char c) {
                children.computeIfAbsent(c, k -> new SumTrieNode(c));
            }

            public SumTrieNode getChild(char c) {
                return children.get(c);
            }

            public void setIsTerminal() {
                isTerminal = true;
            }
        }
    }

    public static void main(String[] args) {
        MapSum ms = new MapSum();
        ms.insert("apple", 3);
        System.out.println(ms.sum("apple"));

        ms.insert("app", 2);
        System.out.println(ms.sum("ap"));
    }

}