package algorithms;

import java.util.Arrays;

public class MaximumLengthofPairChain {

    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> (a[1] - b[1]));

        int cnt = 0;
        int curEnd = Integer.MIN_VALUE;

        for (int[] curPair : pairs) {
            if (curPair[0] > curEnd) {
                cnt++;
                curEnd = curPair[1];
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        int[][] pairs = {{1,2}, {2,3}, {3,4}};
        int[][] pairs1 = {{-10,-8},{8,9},{-5,0},{6,10},{-6,-4},{1,7},{9,10},{-4,7}};
        MaximumLengthofPairChain mlpc = new MaximumLengthofPairChain();
        int cnt = mlpc.findLongestChain(pairs1);
        System.out.println(cnt);
    }
}
