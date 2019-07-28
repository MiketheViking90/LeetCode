package algorithms;

import org.testng.annotations.Test;

import java.util.Arrays;

public class IntervalListIntersectionsTest {

    IntervalListIntersections il = new IntervalListIntersections();


    //A = [[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]]
    @Test
    public void testIntervalIntersection() {
        int[][] A = {
                {0, 2},
                {5, 10},
                {13, 23},
                {24, 25},
        };
        int[][] B = {
                {1, 5},
                {8, 12},
                {15, 24},
                {25, 26},
        };

        int[][] inters = il.intervalIntersection(A, B);
        System.out.println(Arrays.deepToString(inters));
    }
}