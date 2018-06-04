package eighteen.algo;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

    int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }

        int len = s.length();
        if (len <= 1) {
            return len;
        }

        int max = 1;
        int i = 0;
        int j = 0;

        Map<Character, Integer> charToCnt = new HashMap<>();
        charToCnt.put(s.charAt(0), 1);

        while (j < len) {
            if (allUnique(charToCnt)) {
                max = Math.max(max, j - i + 1);
                j += 1;

                if (j == len) {
                    return max;
                }

                char jChar = s.charAt(j);
                int jCnt = charToCnt.getOrDefault(jChar, 0);
                charToCnt.put(jChar, jCnt + 1);
            } else {
                char iChar = s.charAt(i);
                int iCnt = charToCnt.get(iChar);
                charToCnt.put(iChar, iCnt - 1);

                i += 1;
            }
        }

        return max;
    }

    private boolean allUnique(Map<Character, Integer> charToCnt) {
        for (int i : charToCnt.values()) {
            if (i > 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "abcabcbb";

        LongestSubstringWithoutRepeatingCharacters ls = new LongestSubstringWithoutRepeatingCharacters();
        int len = ls.lengthOfLongestSubstring(str);
        System.out.println(len);
    }
}
