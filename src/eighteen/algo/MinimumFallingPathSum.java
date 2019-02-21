package eighteen.algo;

public class MinimumFallingPathSum {
    int minSum = Integer.MAX_VALUE;
    int M;
    int N;

    public int minFallingPathSum(int[][] A) {
        M = A.length;
        N = A[0].length;

        for (int i = 0; i < N; i++) {
            dfs(0, i, 0, A);
        }
        return minSum;
    }

    private void dfs(int m, int n, int sum, int[][] A) {
        if (m < 0 || m >= M || n < 0 || n >= N) {
            return;
        }

        int cur = A[m][n];
        sum += cur;
        if (m == M-1) {
            minSum = Math.min(minSum, sum);
            return;
        }
        dfs(m+1, n-1, sum, A);
        dfs(m+1, n, sum, A);
        dfs(m+1, n+1, sum, A);
    }

    public static void main(String[] args) {
        MinimumFallingPathSum mfps = new MinimumFallingPathSum();
        int[][] matrix = {
            {1,2,3},
            {4,5,6},
            {7,8,9}
        };
        int v = mfps.minFallingPathSum(matrix);
        System.out.println(v);
    }
}
