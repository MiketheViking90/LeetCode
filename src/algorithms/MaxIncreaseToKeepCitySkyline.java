package algorithms;

public class MaxIncreaseToKeepCitySkyline {

    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;

        int[] maxRow = new int[r];
        int[] maxCol = new int[c];

        for (int i = 0; i < r; i++) {
            maxRow[i] = getMaxInRow(i, grid, r);
        }
        for (int i = 0; i < c; i++) {
            maxCol[i] = getMaxInCol(i, grid, c);
        }

        int sum = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int max = Math.min(maxRow[i], maxCol[j]);
                sum += (max - grid[i][j]);
            }
        }
        return sum;
    }

    private int getMaxInCol(int i, int[][] grid, int c) {
        int max = grid[0][i];
        for (int j = 0; j < c; j++) {
            max = Math.max(max, grid[j][i]);
        }
        return max;
    }

    private int getMaxInRow(int i, int[][] grid, int r) {
        int max = grid[i][0];
        for (int j = 0; j < r; j++) {
            max = Math.max(max, grid[i][j]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[][]grid = {
                {3,0,8,4},
                {2,4,5,7},
                {9,2,6,3},
                {0,3,1,0}
        };

        MaxIncreaseToKeepCitySkyline mi = new MaxIncreaseToKeepCitySkyline();
        int i = mi.maxIncreaseKeepingSkyline(grid);
        System.out.println(i);
    }

}
