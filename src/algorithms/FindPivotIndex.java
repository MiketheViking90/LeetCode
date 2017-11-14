package algorithms;

public class FindPivotIndex {

    public int pivotIndex(int[] nums) {
        int len = nums.length;
        int[] rSums = new int[len];
        int[] lSums = new int[len];

        int sum = 0;
        for (int i = 0; i < len; i++) {
            lSums[i] = sum;
            sum += nums[i];
        }

        sum = 0;
        for (int i = len-1; i >= 0; i--) {
            rSums[i] = sum;
            sum += nums[i];
        }
        for (int i = 0; i < len; i++) {
            if (rSums[i] == lSums[i]) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        FindPivotIndex fpi = new FindPivotIndex();
        int[] nums = {1, 7, 3, 6, 5, 6};
        fpi.pivotIndex(nums);
    }

}
