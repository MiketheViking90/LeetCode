package algorithms;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TopoSortDFS {
    public List<Integer> topoSort(int[][] deps) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int[] dep : deps) {
            int from = dep[0];
            int to = dep[1];

            graph.computeIfAbsent(to, k -> new ArrayList<>());

            List<Integer> curAdj = graph.getOrDefault(from, new ArrayList<>());
            curAdj.add(to);
            graph.put(from, curAdj);
        }

        Set<Integer> visited = new HashSet<>();
        Deque<Integer> topoSort = new LinkedList<>();
        for (int node : graph.keySet()) {
            dfs(node, topoSort, visited, graph);
        }
        return new ArrayList<>(topoSort);
    }

    private void dfs(int node, Deque<Integer> topoSort, Set<Integer> visited, Map<Integer, List<Integer>> graph) {
        if (visited.contains(node)) {
            return;
        }
        visited.add(node);
        topoSort.push(node);

        List<Integer> adj = graph.get(node);
        if (adj == null) {
            return;
        }
        for (int next : adj) {
            dfs(next, topoSort, visited, graph);
        }
    }

    public static void main(String[] args) {
        int[][] deps = {
            {5, 2},
            {5, 0},
            {4, 0},
            {4, 1},
            {2, 3},
            {3, 1},
        };

        TopoSortDFS ts = new TopoSortDFS();
        List<Integer> sort = ts.topoSort(deps);
        System.out.println(sort);
    }
}
