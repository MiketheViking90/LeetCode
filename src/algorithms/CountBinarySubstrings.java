package algorithms;

public class CountBinarySubstrings {
    public int countBinarySubstrings(String s) {
        char[] cAry = s.toCharArray();
        int n = 0;

        int i = 0;
        int j = 1;
        while (j < s.length()) {
            if (cAry[i] == cAry[j]) {
                i++;
                j++;
            } else {
                n += getExtensions(cAry, i, j);
                i = j;
                j = i+1;
            }
        }
        return n;
    }

    private int getExtensions(char[] cAry, int i, int j) {
        int cnt = 1;
        int N = cAry.length;

        while (i > 0 && j < N-1
            && cAry[i-1] == cAry[i]
            && cAry[j+1] == cAry[j]) {
            cnt++;
            i--;
            j++;
        }

        return cnt;
    }
}
