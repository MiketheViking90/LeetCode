package archive.algorithms;

import java.util.HashMap;
import java.util.Map;

public class PermutationInAString {

    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> s1CharToCount = getCharToCount(s1);

        if (s1.length() > s2.length()) {
            return false;
        }

        int n = s1.length();
        for (int i = 0; i < n; i++) {
            char c = s2.charAt(i);
            if (s1CharToCount.containsKey(c)) {
                int curCnt = s1CharToCount.get(c);
                s1CharToCount.put(c, curCnt-1);
            }

            if (allZeros(s1CharToCount)) {
                return true;
            }
        }

        for (int i = n; i < s2.length(); i++) {
            char prevChar = s2.charAt(i - n);
            char nextChar = s2.charAt(i);

            if (s1CharToCount.containsKey(prevChar)) {
                int curCnt = s1CharToCount.get(prevChar);
                s1CharToCount.put(prevChar, curCnt+1);
            }

            if (s1CharToCount.containsKey(nextChar)) {
                int curCnt = s1CharToCount.get(nextChar);
                s1CharToCount.put(nextChar, curCnt-1);
            }

            if (allZeros(s1CharToCount)) {
                return true;
            }
        }

        return false;
    }

    private boolean allZeros(Map<Character, Integer> s1CharToCount) {
        for (Map.Entry<Character, Integer> entry : s1CharToCount.entrySet()) {
            if (entry.getValue() > 0) {
                return false;
            }
        }

        return true;
    }

    private Map<Character,Integer> getCharToCount(String str) {
        Map<Character, Integer> charToCount = new HashMap<>();

        for (char c : str.toCharArray()) {
            int curCnt = charToCount.getOrDefault(c, 0);
            charToCount.put(c, curCnt + 1);
        }

        return charToCount;
    }

    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "a";

        PermutationInAString ps = new PermutationInAString();
        ps.checkInclusion(s1, s2);
    }
}
