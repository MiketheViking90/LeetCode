package algorithms;

import java.util.Deque;
import java.util.LinkedList;

public class MaxStack {

    private Deque<Integer> eltStack = new LinkedList<>();
    private Deque<Integer> maxStack = new LinkedList<>();

    public void push(int x) {
        eltStack.push(x);
        if (maxStack.isEmpty() || x >= maxStack.peek()) {
            maxStack.push(x);
        }
    }

    public int pop() {
        int top = eltStack.pop();
        if (top == maxStack.peek()) {
            maxStack.pop();
        }
        return top;
    }

    public int peek() {
        return eltStack.peek();
    }

    public int popMax() {
        return maxStack.pop();
    }

    public int peekMax() {
        return maxStack.peek();
    }

    public static void main(String[] args) {
        MaxStack mStack = new MaxStack();
        mStack.push(1);
        mStack.push(3);
        mStack.push(17);
        mStack.push(2);
        mStack.push(18);
    }
}
