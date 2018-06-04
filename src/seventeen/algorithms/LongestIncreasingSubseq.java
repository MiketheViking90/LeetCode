package seventeen.algorithms;

public class LongestIncreasingSubseq {

    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return n;
        }

        int[] M = new int[n];
        M[0] = 1;

        int max = 1;
        for (int i = 1; i < n; i++) {
            int prevIndex = getPrev(nums, i);
            if (prevIndex == -1) {
                M[i] = 1;
            } else {
                M[i] = M[prevIndex] + 1;
            }
            max = Math.max(max, M[i]);
        }

        return max;
    }

    private int getPrev(int[] nums, int i) {
        int num = nums[i];
        for (int j = i-1; j >= 0; j--) {
            if (nums[j] < num) {
                return j;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,4,7};
        LongestIncreasingSubseq lis = new LongestIncreasingSubseq();
        int m = lis.findNumberOfLIS(nums);
        System.out.println(m);
    }

}
