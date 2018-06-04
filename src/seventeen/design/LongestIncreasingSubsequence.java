package seventeen.design;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] M = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            int prevIndex = getPrevSmallerIndex(nums, i);
            M[i] = Math.max(
                    M[prevIndex] + 1,
                    M[i-1]
            );
        }

        System.out.println(Arrays.toString(M));
        return M[n];
    }

    private int getPrevSmallerIndex(int[] nums, int curIndex) {
        int curNum = nums[curIndex-1];
        for (int i = curIndex-2; i >= 0; i--) {
            if (nums[i] < curNum) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();

        int[] nums1 = {10, 9, 2, 5, 3, 7, 101, 18};
        int[] nums2 = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};

        int l1 = lis.lengthOfLIS(nums1);
        int l2 = lis.lengthOfLIS(nums2);

        System.out.println(l1);
        System.out.println(l2);
    }
}
