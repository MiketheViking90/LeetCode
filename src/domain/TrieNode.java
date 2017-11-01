package domain;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {

    char c;
    Map<Character, TrieNode> children = new HashMap<>();
    boolean isLeaf = false;

    public TrieNode(char c) {
        this.c = c;
    }

    public TrieNode() {}

}
