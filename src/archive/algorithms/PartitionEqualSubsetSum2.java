package archive.algorithms;

import java.util.Arrays;

public class PartitionEqualSubsetSum2 {
    public boolean canPartition(int[] nums) {
        int sum = getSum(nums);
        if (sum % 2 == 1) {
            return false;
        }

        return ksSum(nums, sum) == (sum / 2);
    }

    private int ksSum(int[] nums, int sum) {
        int[][] mem = new int[nums.length+1][sum+1];

        for (int rock = 1; rock < nums.length; rock++) {
            int rockWeight = nums[rock];

            for (int w = 1; w <= sum; w++) {
                if (rockWeight > w) {
                    mem[rock][w] = mem[rock-1][w];
                } else {
                    int addRock = mem[rock-1][w-rockWeight] + rockWeight;
                    int notAdd = mem[rock-1][w];

                    mem[rock][w] = Math.max(addRock, notAdd);
                }
            }
        }
        return mem[nums.length][sum];
    }

    private int getSum(int[] nums) {
        int n = 0;
        for (int num : nums) {
            n += num;
        }
        return n;
    }
}
