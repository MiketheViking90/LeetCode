package seventeen.algorithms;

import java.util.Set;
import java.util.TreeSet;

public class RemoveDuplicateLetters {

    public String removeDuplicateLetters(String s) {
        Set<Character> orderedChars = new TreeSet<>();
        for (char c : s.toCharArray()) {
            orderedChars.add(c);
        }

        StringBuffer sb = new StringBuffer();
        for (char c : orderedChars) {
            sb.append(c);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "cbacdcbc";

        RemoveDuplicateLetters rdl = new RemoveDuplicateLetters();
        String sU = rdl.removeDuplicateLetters(s);
        System.out.println(sU);
    }
}
