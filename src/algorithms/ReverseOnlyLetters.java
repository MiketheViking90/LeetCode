package algorithms;

public class ReverseOnlyLetters {
    public String reverseOnlyLetters(String S) {
        char[] charAry = S.toCharArray();

        int i = 0;
        int j = S.length()-1;
        while (i < j) {
            if (!isChar(charAry[i])) {
                i++;
            } else if (!isChar(charAry[j])) {
                j--;
            } else {
                char c = charAry[i];
                charAry[i] = charAry[j];
                charAry[j] = c;
                i++;
                j--;
            }
        }
        return String.valueOf(charAry);
    }

    private boolean isChar(char c) {
        int ascii = (int) c;
        return (ascii >= 65) && (ascii <= 90) ||
            (ascii >= 97) && (ascii <= 122);
    }

    public static void main(String[] args) {
        ReverseOnlyLetters rol = new ReverseOnlyLetters();
        String s = rol.reverseOnlyLetters("ab-cd]");
        System.out.println(s);
    }
}
