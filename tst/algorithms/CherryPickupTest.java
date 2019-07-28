package algorithms;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CherryPickupTest {

    private CherryPickup cp = new CherryPickup();

    @Test
    public void testCherryPickup() {
        int[][] grid = {
            {0, 1, -1},
            {1, 0, -1},
            {1, 1, 1},
        };
        int cherries = cp.cherryPickupDP(grid);
        System.out.println(cherries);
    }
}