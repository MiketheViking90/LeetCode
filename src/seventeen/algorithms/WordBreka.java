package seventeen.algorithms;

import java.util.HashSet;
import java.util.Set;

public class WordBreka {

    public boolean wordBreak(String str, Set<String> dict) {
        int n = str.length();
        boolean[] M = new boolean[n+1];
        M[0] = true;

        for (int i = 1; i < n; i++) {
            for (int j = i+1; j <= n; j++) {
                String subStr = str.substring(i-1, j);

                if (M[i-1] && dict.contains(subStr)) {
                    System.out.println(subStr);
                    M[j] = true;
                }
            }
        }

        return M[n];
    }

    public static void main(String[] args) {
        Set<String> dict = new HashSet<>();
        dict.add("two");
        dict.add("sig");
        dict.add("ma");

        WordBreka wb = new WordBreka();
        boolean b= wb.wordBreak("twosigma", dict);
        System.out.println(b);
    }
}
