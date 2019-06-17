package algorithms;

public class FactorialTrailingZeros {
    public int trailingZeroes(int n) {
        int cnt = 0;
        while (n % 5 == 0) {
            n /= 5;
            cnt++;
        }
        return cnt;
    }
}
