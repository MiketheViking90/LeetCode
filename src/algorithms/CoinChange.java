package algorithms;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] mem = new int[amount + 1];
        for (int i = 0; i <= amount; i++) {
            mem[i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                int coinVal = coins[j];

                if (i == coinVal) {
                    mem[i] = 1;
                } else if (i > coinVal) {
                    mem[i] = Math.min(mem[i], mem[i-coinVal] + 1);
                }
            }
        }
        int cnt = mem[amount];
        if (cnt == Integer.MAX_VALUE) {
            return -1;
        }
        return mem[amount];
    }

    public static void main(String[] args) {
        CoinChange cc = new CoinChange();
        int[] coins = {1, 2, 5};
        int count = cc.coinChange(coins, 11);
        System.out.println(count);
    }
}
