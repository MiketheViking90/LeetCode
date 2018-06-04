package seventeen.algorithms;

import java.util.Deque;
import java.util.LinkedList;

public class DecodeString {

    public String decodeString(String s) {
        Deque<Integer> multipliers = new LinkedList<>();
        Deque<String> patterns = new LinkedList<>();

        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                multipliers.push(c - '0');
            } else if (Character.isAlphabetic(c)) {
                StringBuilder curPattern = new StringBuilder();
                while (Character.isAlphabetic(c)) {
                    curPattern.append(c);
                    c = s.charAt(++i);
                }

                String curString = curPattern.toString();
                patterns.push(curString);
            }
            i++;
        }

        System.out.println(multipliers);
        System.out.println(patterns);

        StringBuilder decoded = new StringBuilder();
        while (!multipliers.isEmpty() && !patterns.isEmpty()) {
            int curMultip = multipliers.pop();
            String curPattern = patterns.pop();

            while (curMultip-- > 0) {
                decoded.insert(0, curPattern);
            }
        }

        return decoded.toString();
    }

    public static void main(String[] args) {
        String s1 = "3[a]2[bc]"; //return "aaabcbc".
        String s2 = "3[a2[c]]"; // return "accaccacc".
        String s3 = "2[abc]3[cd]ef"; //return "abcabccdcdcdef"

        DecodeString ds = new DecodeString();
        String decode = ds.decodeString(s1);
        System.out.println(decode);
    }
}
