package algorithms;

import java.util.Deque;
import java.util.LinkedList;

public class BasicCalculator {

    public int calculate(String expr) {
        Deque<Character> ops = new LinkedList<>();
        Deque<Integer> vals = new LinkedList<>();

        for (char c : expr.toCharArray()) {
            if (Character.isDigit(c)) {
                int value = c - '0';
                if (vals.isEmpty()) {
                    vals.push(value);
                } else {
                    int pop = vals.pop();
                    char op = ops.pop();
                    int val = evaluate(pop, value, op);
                    vals.push(val);
                }
            } else {
                ops.push(c);
            }
        }

        return 0;
    }

    private int evaluate(int eval, int value, char op) {
        if (op == '+') {
            return eval + value;
        } else {
            return eval - value;
        }
    }

    public static void main(String[] args) {
        BasicCalculator bc = new BasicCalculator();
        int v = bc.calculate("1-2+3-4+5");
        System.out.println(v);
    }
}
