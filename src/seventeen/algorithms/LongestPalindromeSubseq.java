package seventeen.algorithms;

public class LongestPalindromeSubseq {

    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] M = new int[n+1][n+1];

        for (int i = 1; i <= n ; i++) {
            M[i][i] = 1;
        }

        int max = 0;
        for (int i = 0; i < n - 1; i++) {
            char c1 = s.charAt(i);

            for (int j = i+1; j < n; j++) {
                char c2 = s.charAt(j);

                System.out.println(c1 + ", " + c2);
                if (c1 == c2) {
                    System.out.println("\t" + c1 + ", " + c2);
                    M[i][j] = M[i+1][j-1] + 2;
                    max = Math.max(max, M[i][j]);
                } else {
                    M[i][j] = Math.max(M[i+1][j], M[i][j-1]);
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        String s = "bbbab";
        LongestPalindromeSubseq lps = new LongestPalindromeSubseq();
        int len = lps.longestPalindromeSubseq(s);
        System.out.println(len);
    }

}
