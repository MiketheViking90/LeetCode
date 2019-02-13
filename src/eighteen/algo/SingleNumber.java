package eighteen.algo;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        int x = 0;
        for (int n : nums) {
            x ^= n;
        }
        return x;
    }
}
