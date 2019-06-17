package archive.algorithms;

public class NumberOfIslands {

    private static int[] dx = {-1, 0, 0, 1};
    private static int[] dy = {0, -1, 1, 0};

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int cnt = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    exploreDFS(i, j, grid);
                    cnt++;
                }
            }
        }

        return cnt;
    }

    private void exploreDFS(int i, int j, char[][] grid) {
        grid[i][j] = 'X';
        for (int d = 0; d < dx.length; d++) {
            if (shouldExplore(d, i, j, grid)) {
                exploreDFS(i + dx[d], j + dy[d], grid);
            }
        }
    }

    private boolean shouldExplore(int d, int i, int j, char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        boolean isXAxis = (i + dx[d] >= 0) && (i + dx[d] < rows);
        boolean isYAxis = (j + dy[d] >= 0) && (j + dy[d] < cols);

        if (!isXAxis || !isYAxis) {
            return false;
        }

        return (grid[i + dx[d]][j + dy[d]] == '1');
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };

        NumberOfIslands numI = new NumberOfIslands();
        int islands = numI.numIslands(grid);
        System.out.println(islands);
    }
}
