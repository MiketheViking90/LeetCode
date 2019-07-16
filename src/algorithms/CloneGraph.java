package algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CloneGraph {
    Map<Integer, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        return dfs(node);
    }

    public Node dfs2(Node toClone) {
        if (toClone == null) {
            return null;
        }
        if (map.containsKey(toClone.val)) {
            return map.get(toClone.val);
        }

        Node clone = new Node(toClone.val, new ArrayList<>());
        map.put(toClone.val, clone);
        for (Node adj : toClone.neighbors) {
            clone.neighbors.add(dfs2(adj));
        }
        return clone;
    }

    private Node dfs(Node toCopy) {
        if (toCopy == null) {
            return null;
        }
        if (map.containsKey(toCopy.val)) {
            return map.get(toCopy.val);
        }

        Node node = new Node(toCopy.val, new ArrayList<>());
        map.put(toCopy.val, node);

        for (Node n : toCopy.neighbors) {
            node.neighbors.add(dfs(n));
        }
        return node;
    }
}
