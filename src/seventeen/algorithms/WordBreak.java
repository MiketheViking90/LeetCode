package seventeen.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] M = new boolean[n+1];
        M[0] = true;

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                String word = s.substring(j, i);
                System.out.println(word);
                if (M[j] && wordDict.contains(word)) {
                    M[i] = true;
                    break;
                }
            }
        }

        System.out.println(Arrays.toString(M));
        return M[n];
    }


    public static void main(String[] args) {
        WordBreak wb = new WordBreak();
        String s = "twosigma";
        List<String> dict = new ArrayList<>();
        dict.add("two");
        dict.add("sig");
        dict.add("ma");

        boolean isSplit = wb.wordBreak(s, dict);
        System.out.println(isSplit);
    }

}
