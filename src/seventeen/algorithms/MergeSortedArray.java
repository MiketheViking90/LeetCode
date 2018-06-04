package seventeen.algorithms;

import java.util.Arrays;

public class MergeSortedArray {

    static void merge (int[] a, int m, int[] b, int n) {
        int i = m + n + 1;
        while (m >= 0 && n >= 0) {
            if (a[m] > b[n]) {
                a[i--] = a[m--];
            } else {
                a[i--] = b[n--];
            }
        }
        if (n >= 0) {
            while (n >= 0) {
                a[i--] = b[n--];
            }
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{3, 5, 13, 0, 0, 0, 0};
        int[] b = new int[]{1, 2, 17, 19};

        MergeSortedArray.merge(a, 2, b, 3);
        System.out.println(Arrays.toString(a));
    }
}
