package algorithms;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class CloneGraphBFS {
    Map<Integer, Node> valueIndex = new HashMap<>();

    public Node cloneGraph(Node node) {
        Queue<Node> toVisit = new LinkedList<>();
        toVisit.add(node);
        return bfs(toVisit, new HashSet<>());
    }

    private Node bfs(Queue<Node> toVisit, Set<Node> visited) {
        return null;
    }

}
