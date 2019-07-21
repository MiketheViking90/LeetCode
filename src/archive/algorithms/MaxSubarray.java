package archive.algorithms;

public class MaxSubarray {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int i = 0;
        int j = 1;
        int max = nums[i] + nums[j];

        while (j < nums.length) {
            int ni = nums[i];
            int nj = nums[j];

            if (i == j) {
                j++;
            } if (ni < nj) {
                i++;
            } else {
                j++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
    }
}
