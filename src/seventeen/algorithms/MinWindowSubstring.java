package seventeen.algorithms;

import java.util.Arrays;

public class MinWindowSubstring {

    public String minWindow(String s, String t) {
        if (t == null || s == null || s.length() == 0 || t.length() == 0) {
            return "";
        }
        if (s.length() < t.length()) {
            return "";
        }

        int[] charToCount = new int[128];
        for (char c : t.toCharArray()) {
            charToCount[c]--;
        }
        System.out.println(Arrays.toString(charToCount));

        int minLen = Integer.MAX_VALUE;
        String minWindow = "";
        int i = 0;
        int j = 0;
        while (j < t.length()) {
            char c = t.charAt(j++);
            charToCount[c]++;

            if (hasAllChars(charToCount, t) && (j-i) < minLen) {
                minLen = (j-i);
                minWindow = t.substring(i, j+1);
            }
        }

        while (j < s.length()) {
            if (!hasAllChars(charToCount, t)) {
                char c = s.charAt(j++);
                charToCount[c]++;
            } else {
                if ((j-i) < minLen) {
                    minLen = (j-i);
                    minWindow = t.substring(i, j+1);
                }

                char c = s.charAt(i++);
                charToCount[c]--;
            }
        }

        return minWindow;
    }

    private boolean hasAllChars(int[] charToCount, String t) {
        for (char c : t.toCharArray()) {
            if (charToCount[(c - '0')] >= 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        MinWindowSubstring mw = new MinWindowSubstring();
        String window = mw.minWindow("ADOBECODEBANC", "ABC");
        System.out.println(window);
    }

}
