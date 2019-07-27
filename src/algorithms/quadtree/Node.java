package algorithms.quadtree;

import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@ToString
public class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    public Node() {}

    public Node(boolean _val, boolean _isLeaf, Node _topLeft, Node _topRight, Node _bottomLeft, Node _bottomRight) {
        val = _val;
        isLeaf = _isLeaf;
        topLeft = _topLeft;
        topRight = _topRight;
        bottomLeft = _bottomLeft;
        bottomRight = _bottomRight;
    }

    public static void print(Node root) {
        Map<Integer, List<Node>> levelMap = new TreeMap<>();
        fillLevels(root, 0, levelMap);
        levelMap.entrySet().forEach(System.out::println);
    }

    private static void fillLevels(Node root, int lvl, Map<Integer, List<Node>> levelMap) {
        if (root == null) {
            return;
        }
        List<Node> levelNodes = levelMap.getOrDefault(lvl, new ArrayList<>());
        levelNodes.add(root);
        levelMap.put(lvl, levelNodes);
        fillLevels(root.topLeft, lvl+1, levelMap);
        fillLevels(root.bottomLeft, lvl+1, levelMap);
        fillLevels(root.topRight, lvl+1, levelMap);
        fillLevels(root.bottomLeft, lvl+1, levelMap);
    }
}