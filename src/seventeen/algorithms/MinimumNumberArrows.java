package seventeen.algorithms;

import java.util.Arrays;

public class MinimumNumberArrows {

    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> (a[1] - b[1]));

        int cnt = 1;
        int curEnd = points[0][1];
        int i = 1;
        while (i < points.length) {
            if (points[i][0] > curEnd) {
                cnt++;
                curEnd = points[i][1];
            }
        }

        return cnt;
    }

}
