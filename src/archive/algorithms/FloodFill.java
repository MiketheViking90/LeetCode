package archive.algorithms;

import java.util.Arrays;

public class FloodFill {

    private final int[][] dir = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
    };

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int m = image.length;
        int n = image[0].length;
        int color = image[sr][sc];
        boolean[][] visited = new boolean[m][n];
        fill(image, sr, sc, visited, color, newColor);
        System.out.println(Arrays.deepToString(visited));
        return image;
    }

    private void fill(int[][] image, int r, int c, boolean[][] visited, int replaceColor, int newColor) {
        int m = image.length;
        int n = image[0].length;
        if (r < 0 || r >= m || c < 0 || c >= n) {
            return;
        }
        int curColor = image[r][c];
        if (visited[r][c] || curColor != replaceColor) {
            return;
        }

        visited[r][c] = true;
        if (curColor == replaceColor) {
            image[r][c] = newColor;
        }

        for (int[] d : dir) {
            fill(image, r+d[0], c+d[1], visited, replaceColor, newColor);
        }
    }

    public static void main(String[] args) {
        FloodFill ff = new FloodFill();
        int[][] img = {
                {1,1,1},
                {1,1,0},
                {1,0,1},
        };
        ff.floodFill(img, 1,1,2);
        System.out.println(Arrays.deepToString(img));
    }
}
