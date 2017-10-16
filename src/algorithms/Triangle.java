package algorithms;

import java.util.List;

public class Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {
        int lvls = triangle.size();
        int[] M = new int[lvls];

        for (int lvl = lvls; lvl >= 0; lvl--) {
            int len = triangle.get(lvl).size();

            for (int i = 0; i < len; i++) {

            }
        }

        return 2;
    }

}
