package algorithms;

import java.util.Deque;
import java.util.LinkedList;

public class DecodeString {
    public String decodeString(String s) {
        int N = s.length();
        int j = 0;
        String decode = "";
        Deque<Integer> numStack = new LinkedList<>();
        Deque<String> tokenStack = new LinkedList<>();
        while (j < N) {
            char c = s.charAt(j);
            if (c == '[') {
                j++;
            } else if (Character.isDigit(c)) {
                int i = j;
                while (j < N && Character.isDigit(s.charAt(j))) {
                    j++;
                }
                String numAsString = s.substring(i, j);
                numStack.push(Integer.parseInt(numAsString));
            } else if (Character.isAlphabetic(c)) {
                int i = j;
                while (j < N && Character.isAlphabetic(s.charAt(j))) {
                    j++;
                }
                String token = s.substring (i, j);
                tokenStack.push(token);
            } else if (c == ']') {
                String token = tokenStack.pop();
                decode += token;
                int num = numStack.pop();
                decode = apply(num, decode);
                j++;
            }
        }
        return decode;
    }

    private String apply(int num, String decode) {
        String res = "";
        for (int i = 0; i < num; i++) {
            res += decode;
        }
        return res;
    }

    public static void main(String[] args) {
        DecodeString ds = new DecodeString();
        String dcode = ds.decodeString("3[a2[c]]");
        System.out.println(dcode);
    }
}
