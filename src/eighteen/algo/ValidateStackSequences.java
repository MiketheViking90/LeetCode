package eighteen.algo;

import java.util.Deque;
import java.util.LinkedList;

public class ValidateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int n1 = pushed.length;
        int n2 = popped.length;

        Deque<Integer> stack = new LinkedList<>();
        int i = 0;
        int j = 0;
        while (i < n1 && j < n2) {
            if (stack.isEmpty()) {
                stack.push(pushed[i++]);
            } else if (stack.peek() == popped[j]) {
                j++;
                stack.pop();
            } else {
                stack.push(pushed[i++]);
            }
        }
        while (j < n2 && !stack.isEmpty() && stack.peek() == popped[j]) {
            j++;
            stack.pop();
        }

        return stack.isEmpty() && i == n1 && j == n2;
    }

    public static void main(String[] args) {
        int[] p1 = {1,2,3,4,5};
        int[] p2 = {4,5,3,2,1};

        ValidateStackSequences vss = new ValidateStackSequences();
        vss.validateStackSequences(p1, p2);
    }
}
