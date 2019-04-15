package eighteen.algo;

public class FindTheDifference {
    public char findTheDifference(String s, String t) {
        int[] charToCntS = new int[26];
        for (char c : s.toCharArray()) {
            int i = c - 'a';
            charToCntS[i]++;
        }

        for (char c : t.toCharArray()) {
            int i = c - 'a';
            if (charToCntS[i] == 0) {
                return c;
            }
            charToCntS[i]--;
        }
        return 'a';
    }
}
