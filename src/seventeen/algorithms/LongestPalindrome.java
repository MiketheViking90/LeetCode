package seventeen.algorithms;

import java.util.Arrays;

public class LongestPalindrome {

    public int longestPalindrome(String str) {
        int n = str.length();
        boolean[][] M = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            M[i][i] = true;
        }

        int max = 0;
        for (int l = 1; l < n-1; l++) {
            for (int i = 0; i + l< n; i++) {
                char c1 = str.charAt(i);
                char c2 = str.charAt(i+l);

                int j = i+l;
                if (c1 == c2 && M[i+1][j-1]) {
                    M[i][j] = true;
                    max = Math.max(max, l+1);
                }
            }
        }

        System.out.println(Arrays.deepToString(M));
        return max;
    }

    public static void main(String[] args) {
        LongestPalindrome lp = new LongestPalindrome();
        int len = lp.longestPalindrome("abcbcbcdf");
        System.out.println(len);
    }
}
