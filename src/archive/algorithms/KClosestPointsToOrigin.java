package archive.algorithms;

import java.util.Arrays;
import java.util.Comparator;

public class KClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int K) {
        Arrays.sort(points, Comparator.comparingInt(i -> i[0]*i[0] + i[1]*i[1]));
        int[][] res = new int[K][2];
        for (int i = 0; i < K; i++) {
            res[i] = points[i];
        }
        return res;
    }
}
