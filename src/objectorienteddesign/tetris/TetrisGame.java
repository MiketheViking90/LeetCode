package objectorienteddesign.tetris;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TetrisGame {
    private final boolean[][] grid;
    private final int rows;
    private final int cols;
    private int points = 0;

    Piece curPiece;

    public TetrisGame(int m, int n) {
        grid = new boolean[m][n];
        rows = m;
        cols = n;
        curPiece = PieceFactory.getRandomPiece(n);
    }

    public int startGame() throws InterruptedException {
        while (!isOver()) {
            Thread.sleep(3000);
            movePieceDown();

            if (curPieceContacts()) {
                fillGrid(curPiece, grid);
                clearGridAndUpdatePoints(curPiece);
                curPiece = PieceFactory.getRandomPiece(grid[0].length);
            }
        }
        return points;
    }

    public void rotate() {
        curPiece.rotate(grid);
    }

    private void clearGridAndUpdatePoints(Piece curPiece) {
        List<Integer> rowsToClear = new ArrayList<>();
        for (Pair p : curPiece.getArea()) {
            int row = p.getX();
            if (isFull(row, grid)) {
                rowsToClear.add(row);
            }
        }
        for (int row : rowsToClear) {
            Arrays.fill(grid[row], false);
            points += 100;
        }
    }

    private boolean isFull(int row, boolean[][] grid) {
        return !Arrays.asList(grid[row]).contains(false);
    }

    private void fillGrid(Piece curPiece, boolean[][] grid) {
        for (Pair p : curPiece.getArea()) {
            grid[p.getX()][p.getY()] = true;
        }
    }

    private void movePieceDown() {
    }

    private boolean curPieceContacts() {
        for (Pair p : curPiece.getArea()) {
            int x = p.getX();
            int y = p.getY();

            if (x == 0 || grid[x-1][y]) {
                return true;
            }
        }
        return false;
    }

    public boolean isOver() {
        for (int i = 0; i < grid[0].length; i++) {
            if (!grid[0][i]) {
                return false;
            }
        }
        return true;
    }
}
