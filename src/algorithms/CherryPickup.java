package algorithms;

public class CherryPickup {
    int[][] dir = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1},
    };
    public int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] max = new int[m][n];
        boolean[][] visited = new boolean[m][n];

        if (grid[0][0] == 1) {
            dfs(0, 0, 1, grid, max, visited);
        } else {
            dfs(0, 0, 0, grid, max, visited);
        }

        return max[m-1][n-1];
    }

    private void dfs(int r, int c, int cnt, int[][] grid, int[][] max, boolean[][] visited) {
        int m = grid.length;
        int n = grid[0].length;

        visited[r][c] = true;
        max[r][c] = Math.max(max[r][c], cnt);
        for (int[] d : dir) {
            int r1 = r + d[0];
            int c1 = c + d[1];

            if (inGrid(r1, c1, m, n) && !visited[r1][c1]) {
                int v = grid[r1][c1];
                if (v == 0) {
                    dfs(r1, c1, cnt, grid, max, visited);
                } else if (v == 1) {
                    dfs(r1, c1, cnt+1, grid, max, visited);
                }
            }
        }
        visited[r][c] = false;
    }

    private boolean inGrid(int r, int c, int m, int n) {
        return (r >= 0 && r < m && c >= 0 && c < n);
    }

    public int cherryPickupDP(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] mem = new int[m+1][n+1];
        for (int i = 1; i <=m ; i++) {
            for (int j = 1; j <= n; j++) {
                int val = grid[i-1][j-1];
                if (val != -1) {
                    int up = Math.max(0, mem[i - 1][j]);
                    int left = Math.max(0, mem[i][j - 1]);
                    mem[i][j] = up + left + val;
                }
            }
        }
        return mem[m][n];
    }

}
