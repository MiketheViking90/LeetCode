package algorithms;

public class RotateString {
    public boolean rotateString(String A, String B) {
        if (A.length() != B.length()) {
            return false;
        }
        if (A.length() == 0) {
            return true;
        }

        int N = A.length();
        int A0 = A.charAt(0);
        int i = 0;
        while (i < N) {
            if (B.charAt(i) == A0) {
                if (areStringsRotated(A, B, i)) {
                    return true;
                }
            }
            i++;
        }
        return false;
    }

    private boolean areStringsRotated(String a, String b, int i) {
        int N = a.length();
        String pre = b.substring(i, N);
        String post = b.substring(0, i);
        String cat = pre + post;

        return cat.equals(a);
    }

    public static void main(String[] args) {
        String a = "abcde";
        String b = "bcdea";

        RotateString rs = new RotateString();
        boolean bool = rs.rotateString(a, b);
        System.out.println(bool);
    }
}
