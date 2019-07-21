package archive.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals2 {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 1) {
            return intervals;
        }

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int i = 0;
        int j = 1;
        List<int[]> res = new ArrayList<>();
        while (j < intervals.length) {
            int[] iInterval = intervals[i];
            int[] jInterval = intervals[j];

            if (overlaps(iInterval, jInterval)) {
                int min = Math.min(iInterval[1], jInterval[1]);
                int max = Math.max(iInterval[1], jInterval[1]);
                jInterval[0] = min;
                jInterval[1] = max;
            } else {
                int[] merged = {intervals[i][0], intervals[i][1]};
                res.add(merged);
            }
            i++;
            j++;
        }

        return res.toArray(new int[res.size()][]);
    }

    private boolean overlaps(int[] iInterval, int[] jInterval) {
        return jInterval[0] <= iInterval[1];
    }

    public static void main(String[] args) {
        MergeIntervals2 mi = new MergeIntervals2();
        int[][] vals = {
                {15, 18},
                {2, 6},
                {8, 10},
                {1, 3},
                {1, 2},
        };
        mi.merge(vals);
        System.out.println(Arrays.deepToString(vals));
    }
}
