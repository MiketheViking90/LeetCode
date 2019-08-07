package algorithms;

import java.util.Deque;
import java.util.LinkedList;

public class BasicCalculatorII {
    public int calculate(String s) {
        int res = 0;
        int sign = 1;
        Deque<Integer> vals = new LinkedList<>();
        int N = s.length();
        int i = 0;
        while (i < N) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int val = (c - '0') * sign;
                vals.push(val);
            } else if (c == '/') {
                i++;
                int divisor = s.charAt(i) - '0';
                int dividend = vals.pop();
                int quotient = (dividend/divisor);
                vals.push(quotient);
            } else if (c == '*') {
                i++;
                int factor1 = s.charAt(i) - '0';
                int factor2 = vals.pop();
                int product = factor1 * factor2;
                vals.push(product);
            } else if (c == '+') {
                sign = 1;
            } else if (c == '-') {
                sign = -1;
            }
            i++;
        }
        while (!vals.isEmpty()) {
            res += vals.pop();
        }
        return res;
    }
}
