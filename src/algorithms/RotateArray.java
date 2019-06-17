package algorithms;

import java.util.Arrays;

public class RotateArray {
    public void rotate(int[] nums, int k) {
        int N = nums.length;
        if (k > N) {
            return;
        }
        int[] rotated = new int[nums.length];
        for (int i = 0; i+k+1 < N; i++) {
            rotated[i] = nums[i+k+1];
        }

        for (int i = 0; i <= k; i++) {
            rotated[N-k+i-1] = nums[i];
        }
        for (int i = 0; i < N; i++) {
            nums[i] = rotated[i];
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        RotateArray ra = new RotateArray();
        ra.rotate(nums, 2);
        System.out.println(Arrays.toString(nums));
    }
}
