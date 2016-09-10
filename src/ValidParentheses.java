import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */
public class ValidParentheses {

    public boolean isValid(String input) {
        Stack<Character> parentheses = new Stack<>();

        for (char cur : input.toCharArray()) {
            if (isOpenParentheses(cur)) {
                parentheses.push(cur);
            } else {
                if (parentheses.isEmpty()) {
                    return false;
                }
                char matchParentheses = parentheses.pop();
                if (!parenthesesMatch(matchParentheses, cur)) {
                     return false;
                }
            }
        }
        return parentheses.isEmpty();
    }

    private boolean parenthesesMatch(char open, char close) {
        if (open == '(') {
            return close == ')';
        }
        if (open == '[') {
            return close == ']';
        }
        if (open == '{') {
            return close == '}';
        }
        return false;
    }

    private boolean isOpenParentheses(char c) {
        if (c == '{' || c == '[' || c == '(') {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ValidParentheses vp = new ValidParentheses();
        String validInput = "{}[]()()()(((())))";
        String invalidInput = "{((}})(";

        boolean isValid = vp.isValid(validInput);
        System.out.println(isValid);

        isValid = vp.isValid(invalidInput);
        System.out.println(isValid);
    }

}
