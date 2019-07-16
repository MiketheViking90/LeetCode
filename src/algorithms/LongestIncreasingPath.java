package algorithms;

import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

import java.util.HashSet;

public class LongestIncreasingPath {
    public int longestIncreasingPath(int[][] matrix) {
        String path = "";
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                String curPath = dfs(i, j, "", new HashSet<>(), matrix);
                path = (curPath.length() > path.length()) ? curPath : path;
            }
        }
        return path.length();
    }

    private String dfs(int i, int j, String s, HashSet<Pair> visited, int[][] matrix) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix.length) {
            return s;
        }
        if (visited.contains(new Pair(i, j))) {
            return s;
        }
        visited.add(new Pair(i, j));
        s += matrix[i][j];
        dfs(i+1, j, s, visited, matrix);
        dfs(i-1, j, s, visited, matrix);
        dfs(i, j+1, s, visited, matrix);
        dfs(i, j-1, s, visited, matrix);
        visited.remove(new Pair(i, j));
        return "";
    }

    @EqualsAndHashCode
    @RequiredArgsConstructor
    class Pair {
        final int x;
        final int y;
    }
}
