package algorithms;

import java.util.HashMap;
import java.util.Map;

public class SubarraySum {

    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> sumToCount = new HashMap<>();
        sumToCount.put(0, 1);

        int sum = 0;
        int cnt = 0;
        for (int i : nums) {
            sum += i;

            if (sumToCount.containsKey(sum - k)) {
                cnt += (sumToCount.get(sum-k));
            }

            int curCount = sumToCount.getOrDefault(sum, 0);
            sumToCount.put(sum, curCount + 1);
        }

        return cnt;
    }

    public static void main(String[] args) {
        SubarraySum ss = new SubarraySum();
        int[] nums = {1, 3, 2, 6, 4, 2};
        int[] nums1 = {1, 1, 1};
        int k = 2;

        int cnt = ss.subarraySum(nums1, k);
        System.out.println(cnt);
    }

}
