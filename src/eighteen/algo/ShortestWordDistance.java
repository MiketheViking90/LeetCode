package eighteen.algo;

import java.util.Arrays;

public class ShortestWordDistance {
    public int shortestWordDistance(String a, String b) {
        int m = a.length();
        int n = b.length();
        int[][] Mem = new int[m+1][n+1];

        for (int i = 0; i <= m; i++) {
            Mem[0][i] = i;
        }
        for (int i = 0; i <= n; i++) {
            Mem[i][0] = i;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int aChar = a.charAt(i-1);
                int bChar = b.charAt(j-1);

                if (aChar == bChar) {
                    Mem[i][j] = Mem[i-1][j-1];
                } else {
                    int left = Mem[i-1][j];
                    int down = Mem[i][j-1];
                    Mem[i][j] = Math.min(left, down) + 1;
                }
            }
        }

        System.out.println(Arrays.deepToString(Mem));
        return Mem[m][n];
    }

    public static void main(String[] args) {
        ShortestWordDistance swd = new ShortestWordDistance();
        int d = swd.shortestWordDistance("flash", "false");
        System.out.println(d);
    }
}
