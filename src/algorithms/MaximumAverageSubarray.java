package algorithms;

public class MaximumAverageSubarray {

    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        int[] S = new int[n];

        int sum = 0;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            sum += num;
            S[i] = sum;
        }

        double max = (S[k-1] * 1.) / k;
        for (int i = k; i < n; i++) {
            double windowSum = 1.* (S[i] - S[i-k]);
            double curAvg = (windowSum / k);

            max = Math.max(curAvg, max);
        }

        return max;
    }

    public static void main(String[] args) {
        MaximumAverageSubarray mas = new MaximumAverageSubarray();

        int[] nums = {1,12,-5,-6,50,3};
        double avg = mas.findMaxAverage(nums, 4);
        System.out.println(avg);
    }
}
