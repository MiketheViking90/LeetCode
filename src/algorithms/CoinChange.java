package algorithms;

import java.util.Arrays;
import java.util.Collections;

public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);

        int[] M = new int[amount + 1];

        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;

            for (int j = 0; j < coins.length && coins[j] <= i; j++) {
                int coin = coins[j];
                if (coin == i) {
                    min = 1;
                    break;
                } else {
                    int prevAmt = i - coin;
                    if (prevAmt > 0) {
                        if (M[prevAmt] != Integer.MAX_VALUE) {
                            min = Math.min(min, M[prevAmt] + 1);
                        }
                    }
                }
            }
            M[i] = min;
        }

        if (M[amount] == Integer.MAX_VALUE) {
            return -1;
        } else {
            return M[amount];
        }
    }

    public static void main(String[] args) {
        CoinChange cc = new CoinChange();

        int[] coins = {2};
        int cnt = cc.coinChange(coins, 3);
        System.out.println(cnt);
    }

}
