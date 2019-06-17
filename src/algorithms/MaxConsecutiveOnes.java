package algorithms;

public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = 0;

        int i = 0;
        while (i < nums.length) {
            if (nums[i] == 0) {
                i++;
            } else {
                int l = 0;
                while (i < nums.length && nums[i++] == 1) {
                    l++;
                    n = Math.max(l, n);
                }
            }
        }
        return n;
    }
}
