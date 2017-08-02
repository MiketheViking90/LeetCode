package algorithms;

public class PalindromicSubstrings {

    int countSubstrings(String str) {
        int n = str.length();
        boolean[][] M = new boolean[n][n];

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            M[i][i] = true;
            cnt++;
        }

        for (int i = 0; i < n - 1; i++) {
            char c = str.charAt(i);
            char c1 = str.charAt(i+1);
            if (c == c1) {
                M[i][i+1] = true;
                cnt++;
            }
        }

        for (int len = 3; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = (i + len - 1);
                char c = str.charAt(i);
                char c1 = str.charAt(j);
                System.out.println(i + ", " + j);
                if (M[i+1][j-1] && (c == c1)) {
                    System.out.println(str.substring(i, j+1));
                    M[i][j] = true;
                    cnt++;
                }
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        PalindromicSubstrings ps = new PalindromicSubstrings();

        int cnt = ps.countSubstrings("aaa");
        System.out.println(cnt);
    }
}
