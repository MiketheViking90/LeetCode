package interviews.twosigma;

public class Solution {
    private static int[] horizontal = {0, 1, -1, 0};
    private static int[] vertical = {1, 0, 0, -1};

    static int friendCircles(String[] friends) {
        if (friends == null || friends.length == 0) {
            return 0;
        }

        int rows = friends.length;
        int cols = friends[0].length();
        char[][] matrix = getMatrix(friends, rows, cols);

        return getNumCircles(matrix, rows, cols);
    }

    private static int getNumCircles(char[][] matrix, int rows, int cols) {
        int numCircles = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 'Y') {
                    exploreFriendCircle(matrix, i , j, rows, cols);
                    numCircles++;
                }
            }
        }
        return numCircles;
    }

    private static char[][] getMatrix(String[] friends, int rows, int cols) {
        char[][] matrix = new char[rows][cols];

        for (int i = 0; i < rows; i++) {
            matrix[i] = friends[i].toCharArray();
        }

        return matrix;
    }

    private static void exploreFriendCircle(char[][] matrix, int x, int y, int rows, int cols) {
        matrix[x][y] = 'X';
        for (int i = 0; i < vertical.length; i++) {
            int dx = horizontal[i];
            int dy = vertical[i];

            int exploreX = x+dx;
            int exploreY = y+dy;
            boolean xBound = (exploreX >= 0 && exploreX < rows);
            boolean yBound = (exploreY >= 0 && exploreY < cols);
            if (xBound && yBound && matrix[exploreX][exploreY] == 'Y') {
                exploreFriendCircle(matrix, exploreX, exploreY, rows, cols);
            }
        }
    }

    public static void main(String[] args) {
        String[] input = {"YNY", "YNN", "YNN"};
        int cnt = Solution.friendCircles(input);
        System.out.println(cnt);
    }

}
