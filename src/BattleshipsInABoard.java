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

    public static void main(String[] args) {
        BattleshipsInABoard bb = new BattleshipsInABoard();

    }
}
