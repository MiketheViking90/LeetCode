package archive.algorithms;

public class MinFallingPathSum {
    int[][] minSums;
    int min = Integer.MAX_VALUE;

    public int minFallingPathSum(int[][] A) {
        int m = A.length;
        int n = A[0].length;
        minSums = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                minSums[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < A[0].length; i++) {
            getFallingSums(0, 0, i, A);
        }
        return min;
    }

    private void getFallingSums(int sum, int x, int y, int[][] paths) {
        int m = paths.length;
        int n = paths[0].length;

        if (x < 0 || x >= m || y < 0 || y >= n) {
            return;
        }
        int val = paths[x][y];
        sum += val;
        if (x == m-1) {
            min = Math.min(min, sum);
        } else {
            for (int i = -1; i <= 1; i++) {
                getFallingSums(sum, x+1, y+i, paths);
            }
        }
    }
}
