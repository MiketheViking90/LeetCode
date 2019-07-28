package algorithms;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class BombEnemyTest {

    BombEnemy be = new BombEnemy();

    @Test
    public void testMaxKilledEnemies() {
        char[][] grid = {
                {'E'},
        };
        int cnt = be.maxKilledEnemies(grid);
        System.out.println(cnt);
    }
}