package domain;

public class Stack {

    ListNode last;

    public Stack(int d) {
        last = new ListNode(d);
    }

    public ListNode pop() {
        if (last == null) {
            return null;
        }

        ListNode val = last;
        last = last.next;
        return val;
    }

    public void push(int d) {
        ListNode top = new ListNode(d);
        top.next = last;
        last = top;
    }

    public int peek() {
        if (last == null) {
            return 0;
        }
        return last.val;
    }

    public static void main(String[] args) {
        Stack stack = new Stack(1);
        System.out.println(stack.peek());
        stack.push(2);
        System.out.println(stack.peek());
        stack.push(3);
        System.out.println(stack.peek());
        stack.push(4);
        System.out.println(stack.peek());

        System.out.println(stack.pop().val);
        System.out.println(stack.pop().val);
        System.out.println(stack.pop().val);
        System.out.println(stack.pop().val);
    }
}
