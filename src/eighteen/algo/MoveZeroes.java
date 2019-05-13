package eighteen.algo;

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int i = 0;
        int j = 1;

        while (j < nums.length) {
            if (i != 0 && j != 0) {
                i++;
                j++;
            } else if (i == 0 && j != 0) {
                nums[i] = nums[j];
                nums[j] = 0;
                i++;
            } else if (i != 0 && j == 0){

            } else {
                j++;
            }
        }
    }
}
