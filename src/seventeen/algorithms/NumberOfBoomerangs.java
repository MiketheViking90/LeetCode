package seventeen.algorithms;

import java.util.HashMap;
import java.util.Map;

public class NumberOfBoomerangs {

    public int numberOfBoomerangs(int[][] points) {
        int count = 0;

        for (int[] point1 : points) {
            Map<Integer, Integer> groupNumPointsByDist = new HashMap<>();
            for (int[] point2 : points) {
                if (point1 == point2) {
                    continue;
                }

                int dist = getDistance(point1, point2);
                groupNumPointsByDist.put(dist, groupNumPointsByDist.getOrDefault(dist, 0) + 1);
            }

            for (int val : groupNumPointsByDist.values()) {
                count += val * (val - 1);
            }
        }

        return count;
    }

    private int getDistance(int[] a, int[] b) {
        int dx = a[0] - b[0];
        int dy = a[1] - b[1];

        return dx * dx + dy * dy;
    }

    public static void main(String[] args) {
        NumberOfBoomerangs num = new NumberOfBoomerangs();
        int[][] points = {{0, 0}, {0, 1}, {-1, 0}, {1, 0}, {0, -1}};

        int count = num.numberOfBoomerangs(points);
        System.out.println(count);
    }

}
