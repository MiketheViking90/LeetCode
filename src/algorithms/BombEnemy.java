package algorithms;

public class BombEnemy {
    public int maxKilledEnemies(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;

        int[][] mem = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char c = grid[i-1][j-1];
                int up = mem[i-1][j];
                int left = mem[i][j-1];
                if (c == '0') {
                    mem[i][j] = Math.max(up, left);
                } else if (c == 'E') {
                    mem[i][j] = up + left + 1;
                }
            }
        }
        return mem[m][n];
    }
}
