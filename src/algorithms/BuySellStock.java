package algorithms;

public class BuySellStock {

    static int purchase(int[] stocks) {
        int len = stocks.length;
        int[] sellPrice = new int[len];

        int curMax = stocks[len-1];
        for (int i=len-1; i>=0; i--) {
            sellPrice[i] = curMax;
            if (stocks[i] > curMax) {
                curMax = stocks[i];
            }
        }

        int profit = 0;
        for (int i=0; i<len; i++) {
            int curProfit = (sellPrice[i] - stocks[i]);
            if (curProfit > profit) {
                profit = curProfit;
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] stocks = new int[]{150, 115, 75, 95, 60, 70, 90, 30, 50, 55};
        int price = BuySellStock.purchase(stocks);
        System.out.println(price);
    }
}
