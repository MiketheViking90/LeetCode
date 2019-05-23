package eighteen.algo;

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] mem = new int[m][n];

        for (int i = 0; i < m; i++) {
            mem[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            mem[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                mem[i][j] = 1+Math.max(
                    mem[i-1][j], mem[i][j-1]
                );
            }
        }
        return mem[m-1][n-1];
    }

    public int uPaths(int m, int n) {
        int[][] mem = new int[m][n];

        for (int i = 0; i < m; i++) {
            mem[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            mem[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                int up = mem[i-1][j];
                int left = mem[i][j-1];
                mem[i][j] = up + left;
            }
        }

        return mem[m-1][n-1];
    }

    public static void main(String[] args) {
        UniquePaths up = new UniquePaths();
        int n = up.uPaths(7, 3);
        System.out.println(n);
    }
}
