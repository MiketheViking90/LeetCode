package algorithms;

import java.util.*;

public class AlienLanguage {
    public List<Character> getOrder() {
        Map<Character, List<Character>> graph = getGraph();
        Set<Character> visited = new HashSet<>();
        Deque<Character> order = new LinkedList<>();

        for (char c : graph.keySet()) {
            if (!visited.contains(c)) {
                dfs(c, visited, order, graph);
            }
        }

        return new ArrayList<>(order);
    }

    private void dfs(char c, Set<Character> visited, Deque<Character> order, Map<Character, List<Character>> graph) {
        if (visited.contains(c)) {
            return;
        }

        visited.add(c);
        List<Character> adj = graph.get(c);
        for (char nextChar : adj) {
            dfs(nextChar, visited, order, graph);
        }
        order.push(c);
    }

    private Map<Character, List<Character>> getGraph() {
        Map<Character, List<Character>> graph = new HashMap<>();

        graph.put('a', new ArrayList<>());
        graph.put('b', new ArrayList<>());
        graph.put('c', new ArrayList<>());
        graph.put('d', new ArrayList<>());

        graph.get('a').add('c');
        graph.get('d').add('a');
        graph.get('b').add('a');
        graph.get('b').add('d');

        return graph;
    }

    public static void main(String[] args) {
        AlienLanguage al = new AlienLanguage();
        List<Character> order = al.getOrder();
        System.out.println(order);
    }
}
