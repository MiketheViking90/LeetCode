package algorithms;

import java.util.ArrayList;
import java.util.List;

public class DifferentWaysToAddParentheses {

    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> results = new ArrayList<>();
        if (input == null || input.length() == 0) {
            return results;
        }

        if (input.length() == 1) {
            results.add(Integer.valueOf(input));
            return results;
        }

        int n = input.length();
        for (int i = 0; i < n; i++) {
            char c = input.charAt(i);
            if (c == '*' || c == '-' || c == '+') {
                List<Integer> pre = diffWaysToCompute(input.substring(0, i));
                List<Integer> post = diffWaysToCompute(input.substring(i+1));

                for (int a : pre) {
                    for (int b : post) {
                        if (c == '*') {
                            results.add(a * b);
                        } else if (c == '-') {
                            results.add(a - b);
                        } else {
                            results.add(a + b);
                        }
                    }
                }
            }
        }
        return results;
    }

    public static void main(String[] args) {
        String input = "2*3-4*5";
        DifferentWaysToAddParentheses dw = new DifferentWaysToAddParentheses();
        List<Integer> vals = dw.diffWaysToCompute(input);
        System.out.println(vals);
    }
}
