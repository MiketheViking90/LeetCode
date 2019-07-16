package algorithms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(i, new ArrayList<>());
        }

        for (int[] prereq : prerequisites) {
            int from = prereq[0];
            int to = prereq[1];
            graph.get(from).add(to);
        }

        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, visited, graph)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int i, Set<Integer> visited, List<List<Integer>> graph) {
        if (visited.contains(i)) {
            return false;
        }
        visited.add(i);

        List<Integer> adj = graph.get(i);
        for (int next : adj) {
            if (!dfs(next, visited, graph)) {
                return false;
            }
        }
        visited.remove(i);
        return true;
    }

    public static void main(String[] args) {
        int[][] deps = {
            {1, 0},
        };

        CourseSchedule cs = new CourseSchedule();
        boolean b = cs.canFinish(2, deps);
        System.out.println(b);
    }
}
