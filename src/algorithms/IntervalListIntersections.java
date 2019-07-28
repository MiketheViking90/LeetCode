package algorithms;

import java.util.ArrayList;
import java.util.List;

public class IntervalListIntersections {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int aLen = A.length;
        int bLen = B.length;

        List<int[]> intersections = new ArrayList<>();
        int a = 0;
        int b = 0;
        while (a < aLen && b < bLen) {
            int[] aInterval = A[a];
            int[] bInterval = B[b];

            if (hasIntersection(aInterval, bInterval)) {
                int[] intersection = intersect(aInterval, bInterval);
                intersections.add(intersection);
            }
            if (aInterval[1] < bInterval[1]) {
                a++;
            } else {
                b++;
            }
        }
        return intersections.toArray(new int[intersections.size()][2]);
    }

    private boolean hasIntersection(int[] val1, int[] val2) {
        return !(val1[0] > val2[1] || val2[0] > val1[1]);
    }

    private int[] intersect(int[] aInterval, int[] bInterval) {
        return new int[]{Math.max(aInterval[0], bInterval[0]), Math.min(aInterval[1], bInterval[1])};
    }
}
