package eighteen.algo;

public class TotalHammingDistance {
    public int totalHammingDistance(int[] nums) {
        int N = nums.length;
        String[] binNums = new String[N];
        for (int i = 0; i < N; i++) {
            int n = nums[i];
            binNums[i] = toBinary(n);
        }

        int dist = 0;
        for (int i = 0; i < N - 1; i++) {
            for (int j = i+1; j < N; j++) {
                dist += getHammingDist(binNums[i], binNums[j]);
            }
        }
        return dist;
    }

    private int getHammingDist(String a, String b) {
        return 1;
    }

    String toBinary(int n) {
        return Integer.toString(n, 2);
    }

    public static void main(String[] args) {
        TotalHammingDistance thd = new TotalHammingDistance();
        String bin = thd.toBinary(8);

        System.out.println(32>>1);
    }
}
