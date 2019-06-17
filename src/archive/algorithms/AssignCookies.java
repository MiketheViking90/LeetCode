package archive.algorithms;

import java.util.Arrays;

public class AssignCookies {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        if (g.length == 0 || s.length == 0) {
            return 0;
        }

        int i = g.length - 1;
        int j = s.length - 1;

        int cnt = 0;
        while (i >= 0 && j >= 0) {
            if (s[j] >= g[i]) {
                j--;
                i--;
                cnt++;
            } else {
                i--;
            }
        }

        return cnt;
    }

}
