package archive.algorithms;

public class MoveZeroes2 {

    public void moveZeroes(int[] nums) {
        int s = 0;
        int f = 1;

        while (f < nums.length) {
            if (nums[s] == 0 && nums[f] != 0) {
                swap(nums, s, f);
                s++;
                f++;
            }

            if (f < nums.length && nums[f] == 0) {
                f++;
            }
            if (s < nums.length && nums[s] != 0) {
                s++;
            }
        }
    }

    private void swap(int[] nums, int s, int f) {
        int tmp = nums[s];
        nums[s] = nums[f];
        nums[f] = tmp;
    }

    public static void main(String[] args) {
        MoveZeroes2 mz = new MoveZeroes2();
        int[] nums = {0, 1, 0, 3, 12};
        mz.moveZeroes(nums);
    }
}
