package algorithms;

public class ValidPalindrome2 {

    public boolean validPalindrome(String s) {
        int n = s.length();
        int i = 0;
        int j = n-1;

        while (i<j && s.charAt(i) == s.charAt(j)) {
            i++;
            j--;
        }

        if (j <= i) {
            return true;
        }

        String skipLeft = s.substring(i+1, j + 1);
        String skipRight = s.substring(i, j);

        if (isPalin(skipLeft) || isPalin(skipRight)) {
            return true;
        }
        return false;
    }

    private boolean isPalin(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i<j && s.charAt(i) == s.charAt(j)) {
            i++;
            j--;
        }

        return (j <= i);
    }

    public static void main(String[] args) {
        ValidPalindrome2 vp2 = new ValidPalindrome2();

        String str = "racecarz";
        boolean b = vp2.validPalindrome(str);
        System.out.println(b);
    }
}
