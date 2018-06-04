package seventeen.domain;

public class UniquePaths {

    public int uniquePaths(int r, int c) {
        int[][] M = new int[r+1][c+1];

        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                M[i][j] = M[i-1][j] + M[i][j-1] + 1;
            }
        }

        return M[r][c];
    }
}
