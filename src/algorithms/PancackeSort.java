package algorithms;

import java.util.ArrayList;
import java.util.List;

public class PancackeSort {
    public List<Integer> pancakeSort(int[] A) {
        int N = A.length;
        int max = N;
        List<Integer> flips = new ArrayList<>();
        while (!isSorted(A)) {
            int maxIndex = getMaxIndex(A, N);
            flip(A, N);
            flips.add(maxIndex);
            flip(A, N);
            flips.add(N);
        }
        return flips;
    }

    private void flip(int[] a, int n) {
        int mid = n/2;
        for (int i = 0; i < mid; i++) {
            int tmp = a[i];
            a[i] = a[n-1];
            a[n-1] = tmp;
        }
    }

    private boolean isSorted(int[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i] < a[i-1]) {
                return false;
            }
        }
        return true;
    }

    private int getMaxIndex(int[] A, int N) {
        for (int i = 0; i < N; i++) {
            if (A[i] == N) {
                return i;
            }
        }
        return -1;
    }
}
