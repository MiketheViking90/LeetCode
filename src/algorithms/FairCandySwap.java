package algorithms;

import java.util.HashSet;
import java.util.Set;

public class FairCandySwap {
    public int[] fairCandySwap(int[] A, int[] B) {
        int aSum = sum(A);
        int bSum = sum(B);
        int diff = bSum - aSum;

        Set<Integer> setB = new HashSet<>();
        for (int b : B) {
            setB.add(b);
        }
        for (int i : A) {
            int com = i + (diff/2);
            if (setB.contains(com)) {
                return new int[]{i, com};
            }
        }
        return new int[2];
    }

    private int sum(int[] ary) {
        int sum = 0;
        for (int i : ary) {
            sum += i;
        }
        return sum;
    }
}
