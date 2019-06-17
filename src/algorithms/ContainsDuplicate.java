package algorithms;

import java.util.Arrays;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int n = nums[i];
            int n1 = nums[i+1];
            if (n == n1) {
                return false;
            }
        }

        return true;
    }
}
