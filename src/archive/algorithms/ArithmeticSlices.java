package archive.algorithms;

public class ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] A) {
        int len = A.length;
        if (len <= 2) {
            return 0;
        }
        int count = 0;

        int prevDiff = A[1] - A[0];
        for (int i=1; i<A.length-1; i++) {
            int curDiff = A[i+1] - A[i];
            if (curDiff == prevDiff) {
                count++;
            }
            prevDiff = curDiff;
        }
        return count;
    }

    public static void main(String[] args) {
        ArithmeticSlices as = new ArithmeticSlices();

        int[] A = {3, -1, -5, -9};
        int count = as.numberOfArithmeticSlices(A);

        System.out.println(count);
    }
}
