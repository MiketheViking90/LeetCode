package archive.algorithms;

public class IncreasingTripletSubseq {

    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;

        int[] leftLess = new int[n];
        int[] rightMore = new int[n];

        int curMin = nums[0];
        leftLess[0] = curMin;
        for (int i = 1; i < n; i++) {
            if (nums[i] > curMin) {
                leftLess[i] = curMin;
            } else {
                curMin = nums[i];
                leftLess[i] = Integer.MAX_VALUE;
            }
        }

        int curMax = nums[n-1];
        rightMore[n-1] = Integer.MIN_VALUE;
        for (int i = n-2; i >= 0; i--) {
            if (nums[i] < curMax) {
                rightMore[i] = curMax;
            } else {
                curMax = nums[i];
                rightMore[i] = Integer.MIN_VALUE;
            }
        }

        for (int i = 1; i < n-1; i++) {
            if (nums[i] > leftLess[i] && nums[i] < rightMore[i]) {
                System.out.println(leftLess[i] + ", " + nums[i] + ", " + rightMore[i]);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        IncreasingTripletSubseq its = new IncreasingTripletSubseq();

        int[] nums = {1, 2, 3, 4, 5};
        int[] nums1 = {1, 8, 2, -2, 6};
        its.increasingTriplet(nums1);
    }

}
