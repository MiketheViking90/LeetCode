package algorithms;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringNoRepeats {
    public int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }

        int N = s.length();
        if (N == 1) {
            return 1;
        }

        Map<Character, Integer> charCnts = new HashMap<>();
        int i = 0;
        int j = 0;

        char[] sChars = s.toCharArray();
        charCnts.put(sChars[0], 1);

        int max = 0;
        while (j < N) {
            if (isUnique(charCnts)) {
                j++;
                if (j == N) {
                    max = Math.max(max, j-i);
                    return max;
                }
                char c = sChars[j];

                int cnt = charCnts.getOrDefault(c, 0);
                charCnts.put(c, cnt+1);
                max = Math.max(max, j-i);
            } else {
                char c = sChars[i];
                i++;

                int cnt = charCnts.get(c);
                charCnts.put(c, cnt-1);
            }
        }
        return max;
    }

    private boolean isUnique(Map<Character, Integer> charCnts) {
        for (int n : charCnts.values()) {
            if (n > 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LongestSubstringNoRepeats ls = new LongestSubstringNoRepeats();
        String str = "au";
        int m = ls.lengthOfLongestSubstring(str);
        System.out.println(m);
    }
}
