package archive.algorithms;

import java.util.Arrays;

public class NumArray {

    int[] cumulativeSum;

    public NumArray(int[] nums) {
        int N = nums.length;
        cumulativeSum = new int[N];
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += nums[i];
            cumulativeSum[i] = sum;
        }
    }

    public int sumRange(int i, int j) {
        if (i == 0) {
            return cumulativeSum[j];
        }
        return cumulativeSum[j] - cumulativeSum[i-1];
    }

    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray na = new NumArray(nums);
        System.out.println(Arrays.toString(na.cumulativeSum));
    }
}
