package eighteen.algo;

import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

import java.util.HashSet;
import java.util.Set;

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

    @EqualsAndHashCode
    @RequiredArgsConstructor
    class Pair {
        final int x;
        final int y;
    }

    public boolean exist1(char[][] board, String word) {
        char init = word.charAt(0);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == init) {
                    if (dfs(board, i, j, new HashSet<>(), "", word)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, Set<Pair> visited, String curWord, String word) {
        if (curWord.equals(word)) {
            return true;
        }
        if (curWord.length() >= word.length()) {
            return false;
        }
        if (i < 0 || i >= board.length ||
            j < 0 || j >= board[0].length) {
            return false;
        }
        if (visited.contains(new Pair(i, j))) {
            return false;
        }

        char c = board[i][j];
        visited.add(new Pair(i, j));
        Set<Pair> visitedUp = new HashSet<>(visited);
        Set<Pair> visitedDown = new HashSet<>(visited);
        Set<Pair> visitedLeft = new HashSet<>(visited);
        Set<Pair> visitedRight = new HashSet<>(visited);
        return dfs(board, i-1, j, visitedUp, curWord + c, word) ||
            dfs(board, i+1, j, visitedDown, curWord + c, word) ||
            dfs(board, i, j-1, visitedLeft, curWord + c, word) ||
            dfs(board, i, j+1, visitedRight, curWord + c, word);
    }

    public static void main(String[] args) {
        char[][] board =
                {
                        {'A','B','C','E'},
                        {'S','F','C','S'},
                        {'A','D','E','E'}
                };

        WordSearch ws = new WordSearch();
        boolean b = ws.exist1(board, "ABCESCFDEE");
        System.out.println(b);
    }

}
