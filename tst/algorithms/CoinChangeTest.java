package algorithms;

import algorithms.CoinChange;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CoinChangeTest {

    private CoinChange coinChange = new CoinChange();

    @Test
    public void testNoCoins() {
        int[] coins = {};
        int cnt = coinChange.coinChange(coins, 12);
        assertEquals(cnt, -1);
    }

    @Test
    public void testCoinChangeValidCase() {
        int[] coins = {1, 2, 5};
        int cnt = coinChange.coinChange(coins,12);
        assertEquals(cnt, 3);
    }

}