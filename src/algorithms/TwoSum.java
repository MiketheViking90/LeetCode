package algorithms;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] twoSum(int[] nums, int k) {
        Map<Integer, Integer> nToIdx = new HashMap<>();
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            int n = nums[i];
            nToIdx.put(n, i);
        }

        int[] sol = new int[2];
        for (int i = 0; i < len; i++) {
            int n = nums[i];
            int c = k - n;
            if (nToIdx.containsKey(c)) {
                int cIdx = nToIdx.get(c);
                if (cIdx != i)
                return new int[]{i, cIdx};
            }
        }
        return null;
    }

}
