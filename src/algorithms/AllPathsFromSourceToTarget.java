package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllPathsFromSourceToTarget {

    List<List<Integer>> paths = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> paths = new ArrayList<>();
        int[] neighboors = graph[0];

        for (int n : neighboors) {
            List<Integer> path = new ArrayList<>();
            path.add(0);
            dfs(n, graph, path, paths);
        }
        return paths;
    }

    private void dfs(int visiting, int[][] graph, List<Integer> curPath, List<List<Integer>> paths) {
        curPath.add(visiting);
        if (visiting == graph.length - 1) {
            paths.add(new ArrayList<>(curPath));
        }

        int[] neighboors = graph[visiting];
        for (int n : neighboors) {
            dfs(n, graph, curPath, paths);
            curPath.remove(curPath.size()-1);
        }
    }

    public static void main(String[] args) {
        AllPathsFromSourceToTarget ap = new AllPathsFromSourceToTarget();
        int[][] graph = {{4,3,1},{3,2,4},{3},{4},{}};
        List<List<Integer>> paths = ap.allPathsSourceTarget(graph);
        System.out.printf(Arrays.toString(paths.toArray()));
    }

}
