package algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CloneGraph {
    Map<Integer, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        return dfs(node);
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
