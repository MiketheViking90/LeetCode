package algorithms;

import java.util.Arrays;

public class LargestPerimeterTriangle {
    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        int N = A.length;
        int i = N-3;
        int j = N-2;
        int k = N-1;

        while (i >= 0) {
            int a = A[i];
            int b = A[j];
            int c = A[k];
            if (isTriangle(a, b, c)) {
                return a+b+c;
            }
            i--;
            j--;
            k--;
        }
        return 0;
    }

    private boolean isTriangle(int a, int b, int c) {
        return c < a + b;
    }

    public static void main(String[] args) {
        LargestPerimeterTriangle lp = new LargestPerimeterTriangle();
        int[] nums = {2,1,2};
        int p = lp.largestPerimeter(nums);
        System.out.println(p);
    }
}