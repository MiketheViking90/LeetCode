package eighteen.algo;

import java.util.Deque;
import java.util.LinkedList;

public class ValidParenthesisString {
    public boolean checkValidString(String s) {
        return isValid(s, 0, new LinkedList<>());
    }

    private boolean isValid(String s, int i, Deque<Character> prev) {
        if (i == s.length() - 1) {
            return prev.isEmpty();
        }

        char c = s.charAt(i);
        if (c == '(') {
            prev.push(c);
            return isValid(s, i+1, prev);
        } else if (c == ')') {
            if (prev.isEmpty()) {
                return false;
            }
            prev.pop();
            return isValid(s, i+1, prev);
        } else {
            boolean b1 = isValid(s, i+1, prev);
            prev.push('(');
            boolean b2 = isValid(s, i+1, prev);
            prev.pop();
            prev.push(')');
            boolean b3 = isValid(s, i+1, prev);
            return b1 || b2 || b3;
        }
    }

    public static void main(String[] args) {
        ValidParenthesisString vps = new ValidParenthesisString();
        boolean b = vps.checkValidString("(*))");
        System.out.println(b);
    }
}
