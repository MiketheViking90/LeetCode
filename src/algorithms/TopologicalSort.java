package algorithms;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class TopologicalSort {
    public List<String> topologicalSort(List<List<String>> partialOrders) {
        Map<String, List<String>> neighbors = new HashMap<>();
        Set<String> initNodes = new HashSet<>();
        for (List<String> order : partialOrders) {
            initNodes.add(order.get(0));
            initNodes.add(order.get(1));
            updateNeighbors(neighbors, order.get(0), order.get(1));
        }
        for (List<String> order : partialOrders) {
            initNodes.remove(order.get(1));
        }

        Set<String> visited = new HashSet<>();
        Deque<String> fullOrder = new LinkedList<>();
        Queue<String> startNodes = new LinkedList<>(initNodes);
        while (!startNodes.isEmpty()) {
            String node = startNodes.poll();
            dfs(node, visited, fullOrder, neighbors);
        }
        return new ArrayList<>(fullOrder);
    }

    private void dfs(String node, Set<String> visited, Deque<String> fullOrder, Map<String, List<String>> neighbors) {
        visited.add(node);
        if (!neighbors.containsKey(node)) {
            fullOrder.push(node);
            return;
        }
        for (String neigh : neighbors.get(node)) {
            if (!visited.contains(neigh)) {
                dfs(neigh, visited, fullOrder, neighbors);
            }
        }
        fullOrder.push(node);
    }

    private void updateNeighbors(Map<String, List<String>> neighbors, String s, String s1) {
        List<String> neighs = neighbors.getOrDefault(s, new ArrayList<>());
        neighs.add(s1);
        neighbors.put(s, neighs);
    }

    public static void main(String[] args) {
        List<String> o1 = getList("4", "8");
        List<String> o2 = getList("1", "4");
        List<String> o9 = getList("1", "4");
        List<String> o13 = getList("g", "x");
        List<String> o14 = getList("g", "z");
        List<String> o10 = getList("a", "c");
        List<String> o11 = getList("c", "f");
        List<String> o12 = getList("c", "g");
        List<String> o3 = getList("4", "6");
        List<String> o4 = getList("1", "3");
        List<String> o5 = getList("3", "5");
        List<String> o6 = getList("0", "1");
        List<String> o7 = getList("0", "1");
        List<String> o8 = getList("0", "1");

        List<List<String>> input = new ArrayList<>();
        input.add(o1);
        input.add(o2);
        input.add(o3);
        input.add(o3);
        input.add(o4);
        input.add(o5);
        input.add(o6);
        input.add(o7);
        input.add(o8);
        input.add(o9);
        input.add(o10);
        input.add(o11);
        input.add(o12);
        input.add(o13);
        input.add(o14);

        TopologicalSort ts = new TopologicalSort();
        List<String> order = ts.topologicalSort(input);
        System.out.println(order);
    }

    private static List<String> getList(String s1, String s2) {
        List<String> out = new ArrayList<>();
        out.add(s1);
        out.add(s2);
        return out;
    }
}
