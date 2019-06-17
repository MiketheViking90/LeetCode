package archive.algorithms;

import java.util.Arrays;

public class JumpGame {

    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] M = new boolean[n];
        M[0] = true;

        for (int i = 0; i < n; i++) {
            if (M[i] != false) {
                int jump = nums[i];
                for (int j = 1; j <= jump && i + j < n; j++) {
                    if (!M[i + j]) {
                        M[i + j] = true;
                    }
                }
            }
        }

        System.out.println(Arrays.toString(M));
        return M[n-1];
    }

    public static void main(String[] args) {
        int[] nums = {0,2,3};
        JumpGame jg = new JumpGame();
        jg.canJump(nums);
    }
}
