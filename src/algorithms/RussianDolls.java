package algorithms;

import java.util.Arrays;
import java.util.Comparator;

public class RussianDolls {

    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0) {
            return 0;
        }

        Comparator<int[]> wComparator = (int[] e1, int[] e2) -> {
            return Integer.compare(e1[0], e2[0]);
        };

        Arrays.sort(envelopes, wComparator);

        int n = envelopes.length;
        int[] M = new int[n];

        int max = 0;
        M[0] = 1;
        for (int i = 1; i < n; i++) {
            M[i] = 1;
            int[] curEnv = envelopes[i];
            System.out.println(Arrays.toString(curEnv));

            for (int j = 0; j < i; j++) {
                int[] prevEnv = envelopes[j];
                if (prevEnv[0] < curEnv[0] && prevEnv[1] < curEnv[1]) {
                    M[i] = Math.max(M[i], M[j] + 1);
                    System.out.println("\t" + M[i]);
                }
            }
            max = Math.max(M[i], max);
        }
        return max;
    }

    public static void main(String[] args) {
        RussianDolls rd = new RussianDolls();
        int[][] envs = {{5,4}, {6,4}, {6,7}, {2,3}};
        int m = rd.maxEnvelopes(envs);
        System.out.println(m);
    }

}
