package algorithms;

import java.util.Arrays;

public class GameOfLife {
    public void gameOfLife(int[][] board) {
        int r = board.length;
        int c = board[0].length;

        int[][] nextStage = Arrays.copyOf(board, r);
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int liveNeighbors = getLiveNeighborCount(board, i, j);
                int cellVal = board[i][j];

                if (cellVal == 1) {
                    if (liveNeighbors < 2 || liveNeighbors > 3) {
                        nextStage[i][j] = 0;
                    }
                } else {
                    if (liveNeighbors == 3) {
                        nextStage[i][j] = 1;
                    }
                }

            }
        }

        board = Arrays.copyOf(nextStage, nextStage.length);
    }

    private int getLiveNeighborCount(int[][] board, int x, int y) {
        int n = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (!(i==0 && j == 0)) {
                    int r = x + i;
                    int c = y + j;

                    boolean isLive = getIsLive(board, r, c);
                    if (isLive) {
                        n++;
                    }
                }
            }
        }
        return n;
    }

    private boolean getIsLive(int[][] board, int r, int c) {
        return r >= 0 && r < board.length
                && c >= 0 && c < board[0].length
                && board[r][c] == 1;
    }

    public static void main(String[] args) {
        int[][] A = {
            {0,0,1},
            {1,0,1},
            {0,1,0},
            {1,0,1},
            {0,0,1},
        };

        GameOfLife gol = new GameOfLife();
        gol.gameOfLife(A);
        System.out.println(Arrays.deepToString(A));
    }
}
