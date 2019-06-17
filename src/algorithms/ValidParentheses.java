package algorithms;

import java.util.Deque;
import java.util.LinkedList;

public class ValidParentheses {

    boolean isValid(String str) {
        Deque<Character> charStack = new LinkedList<>();

        for (char c : str.toCharArray()) {
            if (isOpen(c)) {
                charStack.push(c);
            } else {
                if (charStack.isEmpty()) {
                    return false;
                }

                char open = charStack.pop();
                if (!matchParens(open, c)) {
                    return false;
                }
            }
        }
        return charStack.isEmpty();
    }

    private boolean isOpen(char c) {
        return c == '(' || c == '[' || c == '{';
    }

    private boolean matchParens(char open, char close) {
        if (open == '(') {
            return close == ')';
        } else if (open == '[') {
            return close == ']';
        } else {
            return close == '}';
        }
    }

}
