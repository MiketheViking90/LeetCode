package archive.algorithms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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

    public int coinChange2(int[] coins, int amount) {
        Arrays.sort(coins);
        Set<Integer> coinVals = new HashSet<>();
        for (int val : coins) {
            coinVals.add(val);
        }

        int[] mem = new int[amount + 1];

        for (int i = 0; i <= coins.length; i++) {
            int curVal = Integer.MAX_VALUE;

            if (coinVals.contains(i)) {
                curVal = 1;
            } else {
                for (int j = 0; j < coins.length && coins[j] < i ; j++) {
                    int coinVal = coins[j];
                    int prevCnt = mem[i - coinVal];
                    if (prevCnt != Integer.MAX_VALUE) {
                        curVal = prevCnt+1;
                    }
                }
            }
            mem[i] = curVal;
        }
        if (mem[amount] == Integer.MAX_VALUE) {
            return -1;
        }
        return mem[amount];
    }

    public static void main(String[] args) {
        CoinChange cc = new CoinChange();

        int[] coins = {1};
        int cnt = cc.coinChange2(coins, 0);
        System.out.println(cnt);
    }

}
