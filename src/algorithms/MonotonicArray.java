package algorithms;

public class MonotonicArray {
    public boolean isMonotonic(int[] A) {
        int N = A.length;
        int i = 0;
        int j = 1;

        while (j<N && A[j] == A[i]) {
            j++;
            i++;
        }
        if (j==N) {
            return true;
        }

        if (A[j] > A[i]) {
            while (j < N) {
                if (A[j] >= A[i]) {
                    i++;
                    j++;
                } else {
                    return false;
                }
            }
        } else {
            while (j < N) {
                if (A[j] <= A[i]) {
                    i++;
                    j++;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
