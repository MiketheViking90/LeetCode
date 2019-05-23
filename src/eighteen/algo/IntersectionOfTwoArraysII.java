package eighteen.algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> numToCount1 = getNumToCount(nums1);
        Map<Integer, Integer> numToCount2 = getNumToCount(nums2);

        List<Integer> intersection = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : numToCount1.entrySet()) {
            int number = entry.getKey();
            if (numToCount2.containsKey(number)) {
                int count = Math.min(numToCount1.get(number), numToCount2.get(number));
                for (int i = 0; i < count; i++) {
                    intersection.add(number);
                }

            }
        }

        int N = intersection.size();
        int[] intersect = new int[N];
        for (int i = 0; i < N; i++) {
            intersect[i] = intersection.get(i);
        }
        return intersect;
    }

    private Map<Integer, Integer> getNumToCount(int[] nums) {
        Map<Integer, Integer> numToCount = new HashMap<>();
        for (int n : nums) {
            int cnt = numToCount.getOrDefault(n, 0);
            numToCount.put(n, cnt+1);
        }
        return numToCount;
    }
}
