package archive.domain;

import java.util.LinkedList;
import java.util.Map;

public class Trie {

    public TrieNode root = new TrieNode();

    public void insert(String word) {
        Map<Character, TrieNode> children = root.children;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            TrieNode node;
            if (children.containsKey(c)) {
                node = children.get(c);
            } else {
                node = new TrieNode(c);
                children.put(c, node);
            }
            children = node.children;

            if (i == word.length()-1) {
                node.isLeaf = true;
            }
        }
    }

    public boolean search(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            Map<Character, TrieNode> children = node.children;
            if (!children.containsKey(c)) {
                return false;
            }

            node = children.get(c);
        }
        return node.isLeaf;
    }

    public void print() {
        java.util.Queue<TrieNode> toPrint = new LinkedList<>();
        toPrint.offer(root);

        while (!toPrint.isEmpty()) {
            int size = toPrint.size();

            StringBuffer curLevel = new StringBuffer();
            for (int i = 0; i < size; i++) {
                TrieNode node = toPrint.poll();
                curLevel.append(" " + node.c);

                for (TrieNode child : node.children.values()) {
                    toPrint.offer(child);
                }
            }
            System.out.println(curLevel);
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("abc");
        trie.insert("abc");
        trie.insert("acf");
        trie.print();

        boolean b = trie.search("ab");
        System.out.println(b);
        b = trie.search("abc");
        System.out.println(b);
    }
}
