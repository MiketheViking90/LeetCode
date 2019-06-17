package archive.algorithms;

public class PerfectSquares {

    public int numSquares(int n) {
        int[] M = new int[n+1];

        for (int i = 1; i <= Math.sqrt(n); i++) {
            M[i*i] = 1;
        }

        for (int i = 1; i <= n; i++) {
            if (M[i] != 1) {
                int minCnt = M[i - 1] + 1;
                for (int j = 1; j < i; j++) {
                    int curCnt = M[j] + M[i - j];
                    minCnt = Math.min(minCnt, curCnt);
                }
                M[i] = minCnt;
            }
        }

        return M[n];
    }

    public static void main(String[] args) {
        PerfectSquares ps = new PerfectSquares();
        int min = ps.numSquares(12);
        System.out.println(min);
    }

}
