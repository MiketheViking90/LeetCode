package archive.domain;

public class Queue1 {

    ListNode start;
    ListNode end;

    public Queue1(int d) {
        start = new ListNode(d);
        end = start;
    }

    public ListNode dequeue() {
        ListNode offQueue = start;
        start = start.next;
        return offQueue;
    }

    public void enqueue(int d) {
        end.next = new ListNode(d);
        end = end.next;
    }

    public void print() {
        ListNode.printList(start);
    }

    public static void main(String[] args) {
        Queue1 q = new Queue1(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        q.enqueue(6);
        q.print();

        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.print();
    }
}
