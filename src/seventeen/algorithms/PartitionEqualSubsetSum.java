package seventeen.algorithms;

import java.util.Arrays;

public class PartitionEqualSubsetSum {

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 != 0) {
            System.out.println(sum);
            return false;
        }

        int maxSum = ksSum(nums, sum/2);
        return (maxSum == sum/2);
    }

    private int ksSum(int[] weights, int W) {
        int n = weights.length;
        int[][] M = new int[n+1][W+1];

        for (int i = 1; i <= n; i++) {
            int weight = weights[i-1];

            for (int j = 1; j <= W; j++) {
                if (weight > j) {
                    M[i][j] = M[i-1][j];
                } else {
                    int include = weight + M[i-1][j-weight];
                    int unInclude = M[i-1][j];

                    M[i][j] = Math.max(include, unInclude);
                }
            }
        }

        System.out.println(Arrays.deepToString(M));
        return M[n][W];
    }

    public static void main(String[] args) {
        PartitionEqualSubsetSum pess = new PartitionEqualSubsetSum();
        int[] nums = {1, 5, 11, 5};
        boolean canPartition = pess.canPartition(nums);
        System.out.println(canPartition);
    }
}
