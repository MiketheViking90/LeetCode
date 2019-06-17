package algorithms;

public class BattleshipsInABoard {
    public int countBattleships(char[][] board) {
        int r = board.length;
        int c = board[0].length;

        int ships = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] == 'X') {
                    findShip(i, j, board);
                    ships++;
                }
            }
        }
        return ships;
    }

    private void findShip(int i, int j, char[][] board) {
        if (board[i][j] == 'X') {
            board[i][j] = 'O';
        }
        if (i > 0 && board[i-1][j] == 'X') {
            findShip(i-1, j, board);
        }
        if (i < board.length-1 && board[i+1][j] == 'X') {
            findShip(i+1, j, board);
        }
        if (j > 0 && board[i][j-1] == 'X') {
            findShip(i, j-1, board);
        }
        if (j < board[0].length-1 && board[i][j+1] == 'X') {
            findShip(i, j+1, board);
        }
    }

    public static void main(String[] args) {
        BattleshipsInABoard bs = new BattleshipsInABoard();
        char[][] board = {{'X','.','.','X'},{'.','.','.','X'},{'.','.','.','X'}};
        bs.countBattleships(board);
    }
}
