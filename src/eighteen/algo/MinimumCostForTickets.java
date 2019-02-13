package eighteen.algo;

import java.util.HashSet;
import java.util.Set;

public class MinimumCostForTickets {
    int[] M;

    Set<Integer> daySet = new HashSet<>();
    int N;
    int[] costs;

    public int mincostTickets(int[] days, int[] costs) {
        this.costs = costs;
        int len = days.length;
        N = days[len-1];
        for (int d : days) {
            daySet.add(d);
        }

        M = new int[len + 1];
        dp(1);
        return M[N];
    }

    private int dp(int i) {
        for (; i <= N; i++) {
            if (daySet.contains(i)) {
                int c1 = dp(i+1) + costs[0];
                int c2 = dp(i+7) + costs[1];
                int c3 = dp(i+30) + costs[2];

                M[i] = Math.min(c1, Math.min(c2, c3));
            } else {
                M[i] = M[i-1];
            }
        }
        return M[N];
    }
}
