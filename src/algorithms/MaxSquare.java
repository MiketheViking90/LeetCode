package algorithms;

public class MaxSquare {

    public int maximalSquare(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int max = 0;
        int r = matrix.length;
        int c = matrix[0].length;
        int[][] maxUpTo = new int[r+1][c+1];
        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                if (matrix[i-1][j-1] == 1) {
                    maxUpTo[i][j] = Math.min(
                            Math.min(maxUpTo[i-1][j], maxUpTo[i][j-1]),
                            maxUpTo[i-1][j-1]
                    ) + 1;
                    max = Math.max(max, maxUpTo[i][j]);
                }
            }
        }

        return max*max;
    }

    public static void main(String[] args) {
        MaxSquare ms = new MaxSquare();
        int M[][] =
                {{0, 1, 1, 0, 1},
                {1, 1, 0, 1, 0},
                {0, 1, 1, 1, 0},
                {1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0}};

        int max = ms.maximalSquare(M);
        System.out.println(max);
    }
}
