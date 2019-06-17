package archive.algorithms;

import java.util.Arrays;

public class EditDistance {

    public int minDistance(String str1, String str2) {
        int n1 = str1.length();
        int n2 = str2.length();

        int[][] M = new int[n1+1][n2+1];

        for (int i = 1; i <= n1; i++) {
            char c1 = str1.charAt(i-1);

            for (int j = 1; j <= n2; j++) {
                char c2 = str2.charAt(j-1);

                if (c1 == c2) {
                    M[i][j] = M[i-1][j-1];
                } else {
                    M[i][j] = Math.min(
                            M[i-1][j],
                            M[i][j-1]
                    ) + 1;
                }

            }
        }

        System.out.println(Arrays.deepToString(M));
        return M[n1][n2];
    }

    public static void main(String[] args) {
        EditDistance ed = new EditDistance();
        String s = "pier";
        String t = "pines";

        int dist = ed.minDistance(s, t);
        System.out.println(dist);

    }
}
