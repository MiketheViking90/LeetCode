package algorithms;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        String minWindow = "";
        int sLen = s.length();
        int[] tAry = new int[128];
        for (char c : t.toCharArray()) {
            tAry[c]++;
        }

        int i = 0;
        int j = 0;

        while (j < sLen) {

            if (isCovered(tAry)) {
                i = getStart(s, tAry, i, j);
                return s.substring(i, j);
            }
            j++;
        }

        return minWindow;
    }

    private int getStart(String s, int[] tAry, int i, int j) {
        while (isCovered(tAry)) {
            i++;
            tAry[s.charAt(i)]--;
        }
        return i-1;
    }

    private boolean isCovered(int[] tAry) {
        for (int i : tAry) {
            if (i > 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";

        MinimumWindowSubstring mws = new MinimumWindowSubstring();
        String min = mws.minWindow(s, t);
        System.out.println(min);
    }
}
