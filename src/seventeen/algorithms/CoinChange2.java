package seventeen.algorithms;

import java.util.Arrays;

public class CoinChange2 {

    public int coinChange(int change, int[] coins) {
        int[] M = new int[change+1];
        Arrays.fill(M, Integer.MAX_VALUE);

        for (int i = 1; i <= change ; i++) {
            for (int coin : coins) {
                if (coin == i) {
                    M[i] = 1;
                    break;
                } else if (coin < i) {
                    if (M[i-coin] != Integer.MAX_VALUE) {
                        M[i] = M[i-coin] + 1;
                    }
                }
            }
        }

        return M[change];
    }

    public static void main(String[] args) {
        CoinChange2 cc = new CoinChange2();
        int[] coins = {2, 3, 5};
        int k = 11;

        int cnt = cc.coinChange(k, coins);
        System.out.println(cnt);
    }
}
