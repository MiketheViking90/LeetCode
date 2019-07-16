package algorithms;

public class JumpGame3 {
    public boolean canJump(int[] nums) {
        int N = nums.length;
        if (N == 1) {
            return true;
        }

        boolean[] canJump = new boolean[N];

        for (int i = 0; i < N; i++) {
            int n = nums[i];
            if (canJump[n]) {
                for (int j = 1; j <= N - i - 1; j++) {
                    canJump[i + j - 1] = true;
                }
            }
        }

        return canJump[N-1];
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        JumpGame3 jg = new JumpGame3();
        boolean b = jg.canJump(nums);
        System.out.println(b);
    }
}
