package seventeen.algorithms;

public class UniquePaths {

    public int uniquePaths(int m, int n) {
        int[][] M = new int[m][n];

        for (int i = 0; i < m; i++) {
            M[i][0] = 1;
        }

        for (int j = 0; j < n; j++) {
            M[0][j] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                M[i][j] = M[i-1][j] + M[i][j-1];
            }
        }

        return M[m-1][n-1];
    }

    public static void main(String[] args) {
        UniquePaths up = new UniquePaths();
        int paths = up.uniquePaths(3, 7);
        System.out.println(paths);
    }

}
