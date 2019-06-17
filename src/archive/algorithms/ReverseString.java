package archive.algorithms;

public class ReverseString {

    public String reverseString(String s) {
        int len = s.length();
        if (len <= 1) {
            return s;
        }

        char[] charArray = s.toCharArray();

        for (int i = 0; i < len / 2; i++) {
            char tmp = charArray[i];
            ;
            charArray[i] = charArray[len - i - 1];
            charArray[len - i - 1] = tmp;
        }


        return String.valueOf(charArray);
    }

    public static void main(String[] args) {
        ReverseString rs = new ReverseString();
        String res = rs.reverseString("abcdefg");
        System.out.println(res);
    }
}
