package algorithms;

public class MaxAreaOfIsland {
    int m;
    int n;
    public int maxAreaOfIsland(int[][] grid) {
        int area = 0;
        m = grid.length;
        n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int curArea = exploreDfs(grid, i, j);
                    area = Math.max(area, curArea);
                }
            }
        }
        return area;
    }

    private int exploreDfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return 0;
        }
        if (grid[i][j] <= 0) {
            return 0;
        }
        grid[i][j] = -1;
        int r = exploreDfs(grid, i+1, j);
        int l = exploreDfs(grid, i-1, j);
        int d = exploreDfs(grid, i, j+1);
        int u = exploreDfs(grid, i, j-1);
        return 1 + r +l + d + u;
    }
}
