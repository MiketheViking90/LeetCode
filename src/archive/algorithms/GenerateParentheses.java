package archive.algorithms;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public List<String> generateParentheses(int n) {
        List<String> parentheses = new ArrayList<>();
        getParentheses(parentheses, "(", n-1, n);
        return parentheses;
    }

    private void getParentheses(List<String> parentheses, String cur, int l, int r) {
        if (l == 0 && r == 0) {
            parentheses.add(cur);
            return;
        }

        if (l > 0) {
            getParentheses(parentheses, cur + "(", l-1, r);
        } if (r > l) {
            getParentheses(parentheses, cur + ")", l, r-1);
        }
    }

    public static void main(String[] args) {
        GenerateParentheses gp = new GenerateParentheses();
        List<String> paren = gp.generateParentheses(3);
        System.out.println(paren);
    }
}
