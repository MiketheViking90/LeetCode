package algorithms;

import java.util.*;

public class ReconstructItinerary {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, List<String>> graph = new HashMap<>();
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);

            List<String> adj = graph.getOrDefault(from, new ArrayList<>());
            adj.add(to);
            Collections.sort(adj);
            graph.put(from, adj);
        }

        Set<String> visited = new HashSet<>();
        Deque<String> itin = new LinkedList<>();
        for (String airport : graph.keySet()) {
            dfs(airport, graph, visited, itin);
        }
        return new ArrayList<>(itin);
    }

    private void dfs(String airport, Map<String, List<String>> graph, Set<String> visited, Deque<String> itin) {
        visited.add(airport);
        List<String> neighbors = graph.get(airport);
        if (neighbors == null) {
            itin.push(airport);
            return;
        }
        for (String neighbor : neighbors) {
            if (!visited.contains(neighbor)) {
                dfs(neighbor, graph, visited, itin);
            }
        }
        itin.push(airport);
    }
}
