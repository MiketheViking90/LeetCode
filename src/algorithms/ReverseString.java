package algorithms;

public class ReverseString {
    public String reverseString(String s) {
        char[] sChars = s.toCharArray();
        int N = s.length();

        for (int i = 0; i < N / 2; i++) {
            int j = (N-i-1);

            char c1 = sChars[i];
            sChars[i] = sChars[j];
            sChars[j] = c1;
        }

        return new String(sChars);
    }
}
