package algorithms;

public class ContiguousArray {

    public int findMaxLength(int[] nums) {
        int n = nums.length;

        int[] sums = new int[n+1];
        int sum = 0;
        for (int i = 1; i < n+1; i++) {
            sum += nums[i-1];
            sums[i] = sum;
        }

        int maxLen = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i+1; j < n; j+=2) {
                int curSum = sums[j+1] - sums[i+1];
                if ((j-i+1)/2 == curSum) {
                    maxLen = Math.max(maxLen, j-i+1);
                }
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 0, 0, 0, 1, 1};
        int[] nums1 = {0, 1};

        ContiguousArray ca = new ContiguousArray();
        int len = ca.findMaxLength(nums);
        System.out.println(len);
    }

}
