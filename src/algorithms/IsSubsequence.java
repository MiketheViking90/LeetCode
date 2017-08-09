package algorithms;

public class IsSubsequence {

    public boolean isSubsequence(String s, String t) {
        int i = 0;
        int j = 0;

        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {
                j++;
            }
        }

        if (i == s.length()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        IsSubsequence is = new IsSubsequence();

        boolean sub =is.isSubsequence("ace", "abcde");
        System.out.println(sub);
    }
}
