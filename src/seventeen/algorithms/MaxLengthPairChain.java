package seventeen.algorithms;

import java.util.Arrays;
import java.util.Comparator;

public class MaxLengthPairChain {

    public int findLongestChain(int[][] pairs) {
        Comparator<int[]> endpointCompare = Comparator.comparingInt(p -> p[1]);
        Arrays.sort(pairs, endpointCompare);

        int i = 1;
        int[] pair = (pairs[0]);
        int cnt = 1;
        int max = 1;
        while (i < pairs.length) {
            int[] nextPair = pairs[i];
            if (nextPair[0] <= pair[1]) {
                cnt = 0;
            } else {
                cnt++;
                max = Math.max(max, cnt);
            }
            pair = nextPair;
            i++;
        }

        return max;
    }
}
