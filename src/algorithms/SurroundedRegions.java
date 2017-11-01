package algorithms;

public class SurroundedRegions {

    public void solve(char[][] grid) {
        int r = grid.length;
        int c = grid[0].length;

        for (int i = 0; i < c; i++) {
            if (grid[0][c] == 'O' || grid[r-1][c] == 'O') {
                fillGrid(grid, 0, c);
            }
        }

        for (int i = 0; i < r; i++) {
            if (grid[i][0] == 'O' || grid[i][c-1] == 'O') {
                fillGrid(grid, 0, c);
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 'O') {
                    grid[i][j] = 'X';
                } else if (grid[i][j] == '#') {
                    grid[i][j] = 'O';
                }
            }
        }
    }

    private void fillGrid(char[][] grid, int i, int c) {

    }
}
