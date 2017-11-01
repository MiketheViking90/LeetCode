package algorithms;

public class LongestCommonSubsequence {

    public int getLongestCommonSubsequence(String str1, String str2) {
        int n1 = str1.length();
        int n2 = str2.length();

        int[][] M = new int[n1][n2];

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                char c1 = str1.charAt(i-1);
                char c2 = str1.charAt(i-j);

                if (c1 == c2) {
                    M[i][j] = M[i-1][j-1] + 1;
                } else {
                    M[i][j] = Math.max(
                            M[i-1][j],
                            M[i][j-1]
                    );
                }
            }
        }

        return M[n1][n2];
    }
}
