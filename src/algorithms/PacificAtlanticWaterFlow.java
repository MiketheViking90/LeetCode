package algorithms;

import java.util.ArrayList;
import java.util.List;

public class PacificAtlanticWaterFlow {
    private int[][] dir = {
        {-1, 0},
        {1, 0},
        {0, -1},
        {0, 1}
    };

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        boolean[][] aFlow = new boolean[m][n];
        boolean[][] pFlow = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            dfs(i, 0, matrix, pFlow);
        }
        for (int i = 0; i < n; i++) {
            dfs(0, i, matrix, pFlow);
        }

        List<List<Integer>> union = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (aFlow[i][j] && pFlow[i][j]) {
                    List<Integer> flow = new ArrayList<>();
                    flow.add(i);
                    flow.add(j);
                    union.add(flow);
                }
            }
        }

        return new ArrayList<>(union);
    }

    private void dfs(int r, int c, int[][] matrix, boolean[][] flow) {
        int m = matrix.length;
        int n = matrix[0].length;

        if (r < 0 || r >= m || c < 0 || c >= n || flow[r][c]) {
            return;
        }

        flow[r][c] = true;

        for (int[] d : dir) {
            dfs(r + d[0], c + d[1], matrix, flow);
        }
    }
}
