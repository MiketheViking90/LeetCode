package algorithms;

public class ClimbingStairs {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }

        int[] counts = new int[n];
        counts[0] = 1;
        counts[1] = 2;

        for (int i = 2; i < n; i++) {
            counts[i] = counts[i-1] + counts[i-2];
        }
        return counts[n-1];
    }
}
