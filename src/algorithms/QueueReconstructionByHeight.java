package algorithms;

import java.util.*;

public class QueueReconstructionByHeight {
    public int[][] reconstructQueue(int[][] people) {
        Map<Integer, List<int[]>> heightToPeople = new HashMap<>();
        for (int[] p : people) {
            List<int[]> curPeople = heightToPeople.getOrDefault(p[0], new ArrayList<>());
            curPeople.add(p);
        }

        List<Integer> heights = new ArrayList<>(heightToPeople.keySet());
        heights.sort((Integer a, Integer b) -> b-a);

        List<int[]> line = new LinkedList<>();
        for (int h : heights) {
            List<int[]> peopleAtHeight = heightToPeople.get(h);
            for (int[] p : peopleAtHeight) {
                int before = p[1];
            }
        }

        int[][] sorted = new int[people.length][2];
        return sorted;
    }
}
