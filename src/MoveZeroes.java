import java.util.Arrays;

public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        int n = nums.length;

        int i = 0;
        while (i<n) {
            while (nums[i] != 0) {
                i++;
            }

            int j = i;
            while (nums[j] == 0 && j<n) {
                j++;
            }

            System.out.println(Arrays.toString(nums));
            System.out.println("\t" + i);
            System.out.println("\t" + j);
            nums[i] = nums[j];
            nums[j] = 0;
        }
    }

    public static void main(String[] args) {

        MoveZeroes mz = new MoveZeroes();
        int[] nums = {0, 1, 0, 3, 12};

        mz.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

}
