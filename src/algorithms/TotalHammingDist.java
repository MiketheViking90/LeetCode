package algorithms;

public class TotalHammingDist {

    static int getHammingDistance(int[] nums) {
        int sum = 0;
        for (int i=0; i<nums.length-1; i++) {
            for (int j=i+1; j<nums.length; j++) {
                int count = getHammingDistance(nums[i], nums[j]);
                sum += count;
            }
        }
        return sum;
    }

    private static int getHammingDistance(int num, int num1) {
        int diff = (num ^ num1);

        int count = 0;
        while (diff > 0) {
            if ((diff & 1) == 1) {
                count++;
            }
            diff = (diff >> 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 14, 2};
        int dist = TotalHammingDist.getHammingDistance(nums);
        System.out.println(dist);
    }
}
