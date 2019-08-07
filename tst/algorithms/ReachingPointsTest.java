package algorithms;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ReachingPointsTest {

    ReachingPoints rp = new ReachingPoints();

    @Test
    public void testReachingPoints() {
        boolean b = rp.reachingPoints(1, 1, 3, 5);
        boolean b1 = rp.reachingPoints(1, 1, 1, 1);
        boolean b2 = rp.reachingPoints(1, 1, 5, 8);
        System.out.println(b + ", F");
        System.out.println(b1 + ", T");
        System.out.println(b2 + ", T");
    }
}