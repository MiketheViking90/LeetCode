package archive.algorithms;

import java.util.*;

public class BrickWall {

    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> columnToGap = new HashMap<>();

        int wallHeight = wall.size();
        for (List<Integer> row : wall) {
            int sum = 0;
            for (int i : row) {
                sum += i;
                if (sum != wallHeight) {
                    int curGaps = columnToGap.getOrDefault(sum, 0);
                    columnToGap.put(sum, curGaps + 1);
                }
            }
        }

        int numBricks = Integer.MAX_VALUE;
        for (int gaps : columnToGap.values()) {
            int curBricks = wallHeight - gaps;
            numBricks = Math.min(numBricks, curBricks);
        }

        return numBricks;
    }

    public static void main(String[] args) {
        BrickWall bw = new BrickWall();
        int[][] nums = {{1,2,2,1},{3,1,2},{1,3,2},{2,4},{3,1,2},{1,3,1,1}};
        int[][] nums1 = {{1}, {1},{1}};
        List<List<Integer>> wall = convert(nums1);

        int bricks = bw.leastBricks(wall);
        System.out.println(bricks);
    }

    private static List<List<Integer>> convert(int[][] arrays) {
        List<List<Integer>> lists = new ArrayList<>();
        for (int[] array : arrays) {
            List<Integer> list = new ArrayList<>();
            for (int i : array) {
                list.add(i);
            }
            lists.add(list);
        }

        return lists;
    }
}
