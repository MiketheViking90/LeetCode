package algorithms;

import lombok.EqualsAndHashCode;

import java.util.HashSet;
import java.util.Set;

public class UniquePathsIII {
    public int uniquePathsIII(int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 1) {
                    return findPaths(i, j, grid, new HashSet<>());
                }
            }
        }
        return 0;
    }

    private int findPaths(int i, int j, int[][] grid, Set<Pair> visited) {
        int M = grid.length;
        int N = grid[0].length;

        if (i < 0 || i >= M || j < 0 || j >= N) {
            return 0;
        }
        if (grid[i][j] == -1) {
            return 0;
        }
        if (grid[i][j] == 2) {
            return 1;
        }
        Pair pair = new Pair(i, j);
        if (visited.contains(pair)) {
            return 0;
        }
        visited.add(pair);
        visited.remove(new Pair(i, j));

        return findPaths(i+1, j, grid, visited) + findPaths(i-1, j, grid, visited)
            + findPaths(i, j+1, grid, visited) + findPaths(i, j-1, grid, visited);
    }

    @EqualsAndHashCode
    class Pair {
        int a;
        int b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    public static void main(String[] args) {
        UniquePathsIII up3 = new UniquePathsIII();
        int[][] grid = {{1,0,0,0},{0,0,0,0},{0,0,2,-1}};
        int n = up3.uniquePathsIII(grid);
        System.out.println(n);
    }
}
