package archive.algorithms;

import java.util.HashMap;
import java.util.Map;

public class LongestHarmoniousSubsequence {

    public int findLHS(int[] nums) {
        Map<Integer, Integer> valueToCount = new HashMap<>();
        for (int n : nums) {
            int curCount = valueToCount.getOrDefault(n, 0);
            valueToCount.put(n, curCount+1);
        }

        int res = 0;
        for (int i : valueToCount.keySet()) {
            if (valueToCount.containsKey(i+1)) {
                res = Math.max(
                        res,
                        valueToCount.get(i) + valueToCount.get(i+1)
                );
            }
        }
        return res;
    }

}
