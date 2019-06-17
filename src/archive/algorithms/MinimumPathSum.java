package archive.algorithms;

import java.util.Arrays;

public class MinimumPathSum {

    public int minPathSum(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;

        int[][] M = new int[r+1][c+1];

        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                int cost = grid[i-1][j-1];

                int prev = Math.min(
                        M[i-1][j],
                        M[i][j-1]
                );
                M[i][j] = prev + cost;
            }
        }

        System.out.println(Arrays.deepToString(M));
        return M[r][c];
    }

    public static void main(String[] args) {
        MinimumPathSum mps = new MinimumPathSum();
        int[][] grid = {
                {1, 1, 6},
                {1, 2, 9},
                {6, 6, 4}
        };

        int cost = mps.minPathSum(grid);
        System.out.println(cost);
    }
}
