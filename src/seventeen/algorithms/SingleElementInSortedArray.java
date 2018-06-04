package seventeen.algorithms;

public class SingleElementInSortedArray {

    int getSingleElement(int[] a) {
        return findIndexBinSearch(a, 0, a.length);
    }

    private int findIndexBinSearch(int[] a, int lo, int hi) {
        if (lo >= hi) {
            return -1;
        }

        int mid = (lo + hi) / 2;
        int midVal = a[mid];
        if (a[mid-1] != midVal && a[mid+1] != midVal) {
            return a[mid];
        }

        return Math.max(
                findIndexBinSearch(a, lo, hi-1),
                findIndexBinSearch(a, lo+1, hi)
        );
    }

    public static void main(String[] args) {
        int[] A = {1,1,2,3,3,4,4,8,8};

        SingleElementInSortedArray sesa = new SingleElementInSortedArray();
        int val = sesa.getSingleElement(A);
        System.out.println(val);
    }
}
