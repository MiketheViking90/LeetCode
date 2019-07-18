package algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class CourseSch {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = getGraph(prerequisites);
        return anyCycles(graph);
    }

    private Map<Integer, List<Integer>> getGraph(int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int[] req : prerequisites) {
            int from = req[0];
            int to = req[1];

            List<Integer> fromVertex = graph.getOrDefault(from, new ArrayList<>());
            fromVertex.add(to);
            graph.put(from, fromVertex);
            graph.computeIfAbsent(to, c -> new ArrayList<Integer>());
        }

        return graph;
    }

    private boolean anyCycles(Map<Integer, List<Integer>> graph) {
        for (int node : graph.keySet()) {
            if (!dfs(node, graph, new HashSet<>())) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int node, Map<Integer, List<Integer>> graph, HashSet<Integer> visited) {
        if (visited.contains(node)) {
            return false;
        }
        visited.add(node);
        List<Integer> adj = graph.get(node);
        for (int next : adj) {
            if (!dfs(next, graph, visited)) {
                return false;
            }
        }
        visited.remove(node);
        return true;
    }

}
