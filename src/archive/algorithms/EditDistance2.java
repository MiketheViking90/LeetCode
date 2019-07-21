package archive.algorithms;

import java.util.Arrays;

public class EditDistance2 {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] mem = new int[m+1][n+1];

        for (int i = 1; i <= m; i++) {
            mem[i][0] = i;
        }
        for (int i = 1; i <= n; i++) {
            mem[0][i] = i;
        }

        for (int i = 1; i <= m ; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    mem[i][j] = mem[i-1][j-1];
                } else {
                    mem[i][j] = Math.min(
                            mem[i-1][j],
                            Math.min(
                                mem[i][j-1],
                                mem[i-1][j-1])
                    ) + 1;
                }
            }
        }

        System.out.println(Arrays.deepToString(mem));

        return mem[m][n];
    }

    public static void main(String[] args) {
        EditDistance2 ed2 = new EditDistance2();

        String w1 = "ros";
        String w2 = "horse";
        System.out.println(ed2.minDistance(w1, w2));
    }
}
