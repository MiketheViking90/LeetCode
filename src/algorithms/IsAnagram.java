package algorithms;

public class IsAnagram {

    public boolean isAnagram(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();

        if (sLen != tLen) {
            return false;
        }

        int[] sCounts = getCharCounts(s);
        int[] tCounts = getCharCounts(t);

        for (int i = 0; i < 128; i++) {
            if (sCounts[i] != tCounts[i]) {
                return false;
            }
        }
        return true;
    }

    private int[] getCharCounts(String s) {
        int[] charCounts = new int[128];

        for (char c : s.toCharArray()) {
            charCounts[c]++;
        }
        return charCounts;
    }

    public static void main(String[] args) {
        String s = "anagram";
        String t = "aangram";

        IsAnagram ia = new IsAnagram();
        boolean isAnagram = ia.isAnagram(s, t);
        System.out.println(isAnagram);
    }

}
