package interviews.convoy;

public class Interview1 {

    public static int pivotSearch(int[] nums) {
        int lo = 0;
        int hi = nums.length-1;
        return binSearch(nums, lo, hi);
    }

    private static int binSearch(int[] nums, int lo, int hi) {
        if (lo < hi) {
            int midIdx = (hi + lo) / 2;

            if (midIdx == 0) {
                return 0;
            }

            int midVal = nums[midIdx];
            if (midVal < nums[midIdx-1]) {
                return midIdx;
            }

            if (nums[midIdx+1] > nums[hi]) {
                return binSearch(nums, midIdx+1, hi);
            } else {
                return binSearch(nums, 0, midIdx-1);
            }

        }
        return -1;
    }

    public static void main(String[] args) {
//        int[] nums = {11,13,17,25,29,1,5,10};
//        int[] nums = {0,1,2,3,4};
        int[] nums = {1,1,1,1,0,1};
        int[] nums1 = {1,0,1,1,1,1};
        int n = pivotSearch(nums);
        System.out.println(n);
    }
}
