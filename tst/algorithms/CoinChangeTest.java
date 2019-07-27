package algorithms;

import org.easymock.EasyMockSupport;
import org.easymock.TestSubject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.easymock.EasyMock.*;
import static org.testng.Assert.assertEquals;

public class CoinChangeTest extends EasyMockSupport {

    @TestSubject
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

    @Test
    public void testMock() {
        CoinChange coinChange = createMock(CoinChange.class);
        int[] asdf = {};
        expect(coinChange.coinChange(asdf, 13)).andReturn(12);
        replay(coinChange);

        int v = coinChange.coinChange(asdf, 13);
        assertEquals(v, 12);
    }

    @DataProvider
    public Object[][] provideValidCoinData() {
        return new Object[][] {
                {new int[]{2, 4, 5}, 13, 15},
                {new int[]{2, 4, 5}, 13, 12},
                {new int[]{2, 4, 5}, 13, 11},
                {new int[]{2, 4, 5}, 13, 2}
        };
    }

    @Test (dataProvider = "provideValidCoinData")
    public void testValidCoinData(int[] coins, int val, int expectedCount) {
        CoinChange coinChange = createMock(CoinChange.class);
        expect(coinChange.coinChange(coins, val)).andReturn(expectedCount);
        replay(coinChange);

        int cnt = coinChange.coinChange(coins, val);
        assertEquals(cnt, expectedCount);
    }

}