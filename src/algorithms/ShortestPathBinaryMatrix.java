package algorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestPathBinaryMatrix {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        if (grid[0][0] == 1) {
            return -1;
        }

        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        Queue<int[]> toVisit = new LinkedList<>();
        int[] start = {0, 0};
        toVisit.add(start);
        int len = 0;

        while (!toVisit.isEmpty()) {
            int size = toVisit.size();
            for (int i = 0; i < size; i++) {
                int[] visit = toVisit.poll();
                int x = visit[0];
                int y = visit[1];
                if (!visited[x][y]) {
                    if (x == m - 1 && y == n - 1) {
                        return len;
                    }
                    visited[x][y] = true;
                    List<int[]> neighboors = getNeighboors(grid, x, y);
                    toVisit.addAll(neighboors);
                }
            }
            len++;
        }
        return -1;
    }

    private List<int[]> getNeighboors(int[][] grid, int x, int y) {
        List<int[]> neighs = new ArrayList<>();
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if ((inGrid(x+i, y+j, grid) && grid[x+i][y+j] == 0)) {
                    int[] coord = {x+i, y+j};
                    neighs.add(coord);
                }
            }
        }
        return neighs;
    }

    private boolean inGrid(int i, int j, int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        return (i >= 0 && i < m && j >= 0 && j < n);
    }

    public static void main(String[] args) {
        ShortestPathBinaryMatrix sp = new ShortestPathBinaryMatrix();
        int[][] grid = {
                {1,0,0},
                {1,1,0},
                {1,1,0},
        };
        int p = sp.shortestPathBinaryMatrix(grid);
        System.out.println(p);
    }
}
