package eighteen.algo;

public class ToeplitzMatrix {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int N = matrix.length;
        int M = matrix[0].length;

        for (int i = 0; i < N; i++) {
            if (!checkDiagonal(i, 0, matrix)) {
                return false;
            }
        }

        for (int j = 1; j < M; j++) {
            if (!checkDiagonal(0, j, matrix)) {
                return false;
            }
        }

        return true;
    }

    private boolean checkDiagonal(int i, int j, int[][] matrix) {
        int val = matrix[i][j];

        int N = matrix.length;
        int M = matrix[0].length;

        while (i < N && j < M) {
            int v = matrix[i][j];
            if (v != val) {
                return false;
            }
            i++;
            j++;
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] M = {
                {1,2,3,4},
                {5,1,2,3},
                {9,5,1,2}
        };

        ToeplitzMatrix tm = new ToeplitzMatrix();
        boolean b = tm.isToeplitzMatrix(M);
        System.out.println(b);
    }
}
