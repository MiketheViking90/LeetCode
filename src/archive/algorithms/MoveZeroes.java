package archive.algorithms;

import java.util.Arrays;

public class MoveZeroes {

    public void moveZeroes(int[] nums) {

        int curIndex = getNextZeroIndex(0, nums);
        int nextIndex = getNextNonZeroIndex(0, nums);

        while (nextIndex < nums.length) {
            nums[curIndex] = nums[nextIndex];
            nums[nextIndex] = 0;

            System.out.println(Arrays.toString(nums));
            curIndex = getNextZeroIndex(curIndex + 1, nums);
            nextIndex = getNextNonZeroIndex(nextIndex + 1, nums);

            if (curIndex == -1 || nextIndex == -1) {
                return;
            }
            System.out.println("cur: " + curIndex + ": " + nums[curIndex] + " next: " + nextIndex + ": " + nums[nextIndex]);
        }
    }

    private int getNextNonZeroIndex(int i, int[] nums) {
        while (nums[i] == 0) {
            if (i == nums.length) {
                return -1;
            }
            i++;
        }
        return i;
    }

    private int getNextZeroIndex(int i, int[] nums) {
        while (nums[i] != 0) {
            if (i >= nums.length) {
                return -1;
            }
            i++;
        }
        return i;
    }

    public static void main(String[] args) {
        MoveZeroes mz = new MoveZeroes();

        int[] nums = {0, 1, 0, 3, 12};
        mz.moveZeroes(nums);
    }
}
