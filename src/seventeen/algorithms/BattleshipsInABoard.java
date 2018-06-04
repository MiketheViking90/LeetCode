package seventeen.algorithms;

public class BattleshipsInABoard {
    public int countBattleships(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        int count = 0;
        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                char val = board[i][j];
                if (hasNotBeenCounted(i, j, board) && isBattleship(val)) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean hasNotBeenCounted(int x, int y, char[][] board) {
        if (x==0 && y==0) {
            return true;
        }
        if (x==0) {
            return board[x][y-1] != 'X';
        }
        if (y==0) {
            return board[x-1][y] != 'X';
        }
        boolean prevX = board[x-1][y] != 'X';
        boolean prevY = board[x][y-1] != 'X';
        return prevX && prevY;
    }

    private boolean isBattleship(char val) {
        return val == 'X';
    }

    public int countBattleships2(char[][] board) {
        int r = board.length;
        int c= board[0].length;

        int cnt = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                boolean shouldCount = shouldCount(i, j, board);
                if (shouldCount) {
                    cnt++;
                }
            }
        }

        return cnt;
    }

    private boolean shouldCount(int i, int j, char[][] board) {
        if (board[i][j] != 'X') {
            return false;
        }

        int r = board.length;
        int c= board[0].length;

        if (i == 0 && j == 0) {
            return true;
        }
        if (i == 0) {
            return board[i][j-1] != 'X';
        }
        if (j == 0) {
            return board[i-1][j] != 'X';
        }
        return board[i-1][j] != 'X' && board[i][j-1] != 'X';
    }

    public static void main(String[] args) {
        BattleshipsInABoard bb = new BattleshipsInABoard();
    }
}
