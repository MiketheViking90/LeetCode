package algorithms;

import java.util.HashSet;
import java.util.Set;

public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        Set<Integer> rows = new HashSet<>();
        for (int i = 0; i < m; i++) {
            rows.add(i);
        }
        Set<Integer> cols = new HashSet<>();
        for (int i = 0; i < n; i++) {
            cols.add(i);
        }

        int minR = 0;
        int maxR = m - 1;
        int minC = 0;
        int maxC = n - 1;
        while (minR != maxR && minC != maxC) {
            for (int i = minR; i <= maxR; i++) {
                int[] row = matrix[i];
                if (k < row[minC] || k > row[maxC]) {
                    minR = Math.max(minR, i);
                    maxR = Math.min(maxR, i);
                }
            }

            for (int j = minC; j <= maxC; j++) {
                if (k < matrix[minR][j] || k > matrix[maxR][j]) {
                    minC = Math.max(minC, j);
                    maxC = Math.min(maxC, j);
                }
            }
        }

        return matrix[minR][minC] == k;
    }

    public static void main(String[] args) {
        SearchA2DMatrix sm = new SearchA2DMatrix();
    }
}
