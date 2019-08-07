package algorithms;

import java.util.Deque;
import java.util.LinkedList;

public class BasicCalculator2 {
    public int calculatePlusMinus(String s) {
        int res = 0;
        int sign = 1;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                int val = c - '0';
                res += (sign * val);
            } else {
                if (c == '+') {
                    sign = 1;
                } else {
                    sign = -1;
                }
            }
        }
        return res;
    }

    public int calculate(String s) {
        int res = 0;
        int sign = 1;
        Deque<Integer> parenthState = new LinkedList<>();

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                int val = c - '0';
                res += (val * sign);
            } else if (c == '+') {
                sign = 1;
            } else if (c == '-') {
                sign = -1;
            } else if (c == '(') {
                parenthState.push(res);
                parenthState.push(sign);
                res = 0;
                sign = 1;
            } else if (c == ')') {
                res *= parenthState.pop();
                res += parenthState.pop();
            }
        }
        return res;
    }
}
