package archive.algorithms;

import java.util.Arrays;

public class HouseRobber {

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length+1;
        int[] M = new int[n];
        M[1] = nums[0];

        for (int i = 2; i < n; i++) {
            System.out.println(Arrays.toString(M));
            System.out.println(i + ", " + nums[i-1]);

            int with = M[i-2] + nums[i-1];
            int without = M[i-1];

            M[i] = Math.max(with, without);
        }

        return M[n-1];
    }

    public static void main(String[] args) {
        HouseRobber hr = new HouseRobber();

        int[] nums = {2, 7, 6, 1, 1, 8};
        int rob = hr.rob(nums);
        System.out.println(rob);
    }

}
