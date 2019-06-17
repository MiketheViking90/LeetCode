package archive.algorithms;

import java.util.Arrays;

public class CountOfRangeSums {

    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        int[] sums = new int[n+1];

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            sums[i+1] = sum;
        }

        System.out.println(Arrays.toString(sums));

        return -1;
    }

    public static void main(String[] args) {
        CountOfRangeSums crs = new CountOfRangeSums();
        int[] nums = {-2, -1, 2};
        crs.countRangeSum(nums, -2, 2);
    }

}
