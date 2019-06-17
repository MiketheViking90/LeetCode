package algorithms;

public class FlippingAnImage {

    public int[][] flipAndInvertImage(int[][] A) {
        for (int[] row : A) {
            flipRow(row);
        }
        invertMatrix(A);
        return A;
    }

    private void invertMatrix(int[][] A) {
        int r = A.length;
        int c = A[0].length;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int v = A[i][j];
                int v1 = (v == 1) ? 0 : 1;
                A[i][j] = v1;
            }
        }
    }

    private void flipRow(int[] row) {
        int n = row.length;
        for (int i = 0; i < n / 2; i++) {
            int j = n - i - 1;

            int t = row[i];
            row[i] = row[j];
            row[j] = t;
        }
    }

}
