package algorithms;

import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

import java.util.*;

public class WallsAndGates {
    private static final int empty = Integer.MAX_VALUE;

    public void wallsAndGates(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == empty) {
                    int d = bfs(grid, i, j);
                    grid[i][j] = d;
                }
            }
        }
    }

    @RequiredArgsConstructor
    @EqualsAndHashCode
    class Pair {
        final int x;
        final int y;
    }

    private int bfs(int[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<Pair> q = new LinkedList<>();
        Set<Pair> visited = new HashSet<>();
        q.add(new Pair(i, j));
        int level = 0;

        while (!q.isEmpty()) {
            int levelSize = q.size();
            while (levelSize > 0) {
                Pair visit = q.poll();
                visited.add(visit);
                levelSize--;

                int x = visit.x;
                int y = visit.y;
                if (x >= 0 && x < m && y >= 0 && y < n) {
                    int val = grid[x][y];
                    if (val == 0) {
                        return level;
                    }

                    if (val != -1) {
                        Pair up = new Pair(i-1, j);
                        if (!visited.contains(up)) {
                            q.offer(up);
                        }
                        Pair down = new Pair(i+1, j);
                        if (!visited.contains(down)) {
                            q.offer(down);
                        }
                        Pair left = new Pair(i, j-1);
                        if (!visited.contains(left)) {
                            q.offer(left);
                        }
                        Pair right = new Pair(i, j+1);
                        if (!visited.contains(right)) {
                            q.offer(right);
                        }
                    }
                }

            }

            level++;
        }

        return empty;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {empty, -1, 0, empty},
                {empty, empty, empty, -1},
                {empty, -1, empty, -1},
                {0, -1, empty, empty},
        };

        WallsAndGates wag = new WallsAndGates();
        wag.wallsAndGates(grid);
        System.out.println(Arrays.deepToString(grid));
    }
}
