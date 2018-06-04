package eighteen.algo;

public class WordSearch {

    public boolean exist(char[][] board, String word) {
        int r = board.length;
        int c = board[0].length;

        int i = 0;
        int j = 0;

        while (i < r && j < c) {
            boolean[][] visited = new boolean[r][c];
            visited[i][j] = true;
            if (dfs(board, word, i, j, 0, visited)) {
                return true;
            }

            if (i != r-1) {
                i++;
            } else {
                i = 0;
                j++;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int idx, boolean[][] visited) {
        if (i < 0 || i >= board.length) {
            return false;
        }
        if (j < 0 || j >= board[0].length) {
            return false;
        }
        if (visited[i][j]) {
            return false;
        }
        visited[i][j] = true;

        char wChar = word.charAt(idx);
        char c = board[i][j];

        if (wChar != c) {
            return false;
        } else if (idx == word.length() - 1) {
            return true;
        }

        boolean res =  dfs(board, word, i - 1, j, idx+1, visited)
                || dfs(board, word, i + 1, j, idx+1, visited)
                || dfs(board, word, i, j - 1, idx+1, visited)
                || dfs(board, word, i, j + 1, idx+1, visited);
        visited[i][j] = false;
        return res;
    }

    public static void main(String[] args) {
        char[][] board =
//                {
//                        {'A','B','C','E'},
//                        {'S','F','C','S'},
//                        {'A','D','E','E'}
//                };
                {{'A', 'A'}};

        WordSearch ws = new WordSearch();
        boolean b = ws.exist(board, "AAA");
        System.out.println(b);
    }

}
