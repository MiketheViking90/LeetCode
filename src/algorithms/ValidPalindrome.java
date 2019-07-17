package algorithms;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                sb.append(c);
            }
        }
        String str = sb.toString();
        int mid = str.length()/2;
        str = str.toLowerCase();
        char[] sChars = str.toCharArray();

        return isPalindrome(sChars, mid, mid) || isPalindrome(sChars, mid, mid+1);
    }

    private boolean isPalindrome(char[] sChars, int l, int r) {
        while (l >= 0 && r < sChars.length) {
            char lChar = sChars[l--];
            char rChar = sChars[r++];
            if (lChar != rChar) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome vp = new ValidPalindrome();
        String str = "ab";
        boolean b = vp.isPalindrome(str);
        System.out.println(b);
    }
}
