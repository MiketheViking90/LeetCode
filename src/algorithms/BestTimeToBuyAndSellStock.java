package algorithms;

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int N = prices.length;
        int[] maxFuture = new int[N];

        int curMax = -1;
        for (int i = N-1; i >= 0; i--) {
            curMax = Math.max(curMax, prices[i]);
            maxFuture[i] = curMax;
        }

        int maxProfit = -1;
        for (int i = 0; i < N; i++) {
            int profit = maxFuture[i] - prices[i];
            maxProfit = Math.max(maxProfit, profit);
        }
        return maxProfit;
    }
}
