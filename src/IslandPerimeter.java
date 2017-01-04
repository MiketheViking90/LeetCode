public class IslandPerimeter {

    public int islandPerimeter(int[][] grid) {
        int sum = 0;

        int length = grid.length;
        int width = grid[0].length;

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                if (grid[i][j] == 1) {
                    int cellPerimeter = calculatePerimeter(i, j, length, width, grid);
                    sum += cellPerimeter;
                }
            }
        }

        return sum;
    }

    private int calculatePerimeter(int i, int j, int length, int width, int[][] grid) {
        int perimeter = 0;
        if (i == 0) {
            perimeter++;
        } else if (grid[i - 1][j] == 0) {
            perimeter++;
        }

        if (i == length - 1) {
            perimeter++;
        } else if (grid[i + 1][j] == 0) {
            perimeter++;
        }

        if (j == 0) {
            perimeter++;
        } else if (grid[i][j - 1] == 0) {
            perimeter++;
        }

        if (j == width - 1) {
            perimeter++;
        } else if (grid[i][j + 1] == 0) {
            perimeter++;
        }

        return perimeter;
    }

    public static void main(String[] args) {
        IslandPerimeter ip = new IslandPerimeter();

        int[][] grid = {
                {0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}
        };

        int perimeter = ip.islandPerimeter(grid);
        System.out.println(perimeter);
    }
}
