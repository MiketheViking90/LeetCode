package archive.algorithms;

public class BestTimeBuySellStock {

    public int maxProfit(int[] prices) {
        int min = prices[0];

        int n = prices.length;
        int maxProfit = 0;
        for (int i = 0; i < n; i++) {
            int price = prices[i];
            if (price > min) {
                maxProfit = Math.max(maxProfit, price - min);
            } else if (price < min) {
                min = price;
            }
        }

        return maxProfit;
    }
}
