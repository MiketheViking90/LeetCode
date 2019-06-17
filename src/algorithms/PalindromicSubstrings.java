package algorithms;

public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        int n = 0;
        int N = s.length();

        for (int i = 0; i < N; i++) {
            int l = i;
            int r = l;
            while (isPalindrome(s, N, l, r)) {
                l--;
                r++;
                n++;
            }

            l = i;
            r = i+1;
            while (isPalindrome(s, N, l, r)) {
                l--;
                r++;
                n++;
            }
        }
        return n;
    }

    private boolean isPalindrome(String s, int n, int l, int r) {
        return l >= 0 && r < n && s.charAt(l) == s.charAt(r);
    }
}
