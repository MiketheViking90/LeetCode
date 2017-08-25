package design;

import java.util.Deque;
import java.util.LinkedList;

class MyQueue {

    Deque<Integer> stack1;
    Deque<Integer> stack2;

    public MyQueue() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }

    public void push(int x) {
        Deque<Integer> fullStack = stack1.isEmpty() ? stack2 : stack1;
        Deque<Integer> emptyStack = stack1.isEmpty() ? stack1 : stack2;

        while (!fullStack.isEmpty()) {
            emptyStack.offer(fullStack.pop());
        }
        emptyStack.offer(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        Deque<Integer> fullStack = stack1.isEmpty() ? stack2 : stack1;
        return fullStack.pop();
    }

    /** Get the front element. */
    public int peek() {
        Deque<Integer> fullStack = stack1.isEmpty() ? stack2 : stack1;
        return fullStack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue q = new MyQueue();
        q.push(1);
        q.push(2);
        q.push(3);
        q.push(4);
        q.push(5);

        while (!q.empty()) {
            System.out.println(q.pop());
        }
    }
}

