package algorithms;

public class MinPathSum {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] mem = new int[m][n];
        mem[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            mem[i][0] = mem[i-1][0] + grid[i][0];
        }
        for (int i = 1; i < n; i++) {
            mem[0][i] = mem[0][i-1] + grid[0][i];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                int val = grid[i][j];
                int up = mem[i-1][j];
                int left = mem[i][j-1];
                mem[i][j] = Math.min(up, left) + val;
            }
        }
        return mem[m-1][n-1];
    }
}
