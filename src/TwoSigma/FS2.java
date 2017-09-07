package TwoSigma;

import java.util.LinkedList;
import java.util.Queue;

public class FS2 {

    static int friendCircles(String[] friends) {
        if (friends == null || friends.length == 0) {
            return 0;
        }

        int rows = friends.length;
        int cols = friends[0].length();
        char[][] matrix = getMatrix(friends, rows, cols);

        return countFriendCircles(matrix);
    }

    private static char[][] getMatrix(String[] friends, int rows, int cols) {
        char[][] matrix = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            matrix[i] = friends[i].toCharArray();
        }
        return matrix;
    }

    private static int countFriendCircles(char[][] matrix) {
        int count = 0;
        for (int i=0; i<matrix.length; i++)
            if (matrix[i][i] == 1) {
                countFriendsBFS(i, matrix);
                count++;
            }
        return count;
    }

    private static void countFriendsBFS(int friend, char[][] matrix) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(friend);
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                int curFriend = queue.poll();
                matrix[curFriend][curFriend] = 'X';

                for (int k=0;k<matrix[0].length;k++)
                    if (matrix[curFriend][k] == 1 && matrix[k][k] == 1) queue.add(k);
            }
        }
    }

}
