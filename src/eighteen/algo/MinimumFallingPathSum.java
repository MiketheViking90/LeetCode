package eighteen.algo;

public class MinimumFallingPathSum {
    int minSum = Integer.MAX_VALUE;
    int M;
    int N;
    int[][] MEM;

    public int minFallingPathSum(int[][] A) {
        M = A.length;
        N = A[0].length;
        MEM = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                MEM[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < N; i++) {
            dfs(0, i, 0, A);
        }
        return minSum;
    }

    private int dfs(int m, int n, int sum, int[][] A) {
        if (m < 0 || m >= M || n < 0 || n >= N) {
            return Integer.MAX_VALUE;
        }
        int cur = A[m][n];
        if (MEM[m][n] != Integer.MAX_VALUE) {
            return cur + MEM[m][n];
        } else {
            sum += cur;
            if (m == M - 1) {
                minSum = Math.min(minSum, sum);
            }
            int a = dfs(m + 1, n - 1, sum, A);
            int b = dfs(m + 1, n, sum, A);
            int c = dfs(m + 1, n + 1, sum, A);
            int min = Math.min(a, Math.min(b, c));
            MEM[m][n] = min;
            return min;
        }
    }
}
