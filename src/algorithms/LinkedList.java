package algorithms;

import domain.ListNode;

public class LinkedList {

    void insert(ListNode head, int d) {
        while (head.next != null) {
            head = head.next;
        }
        head.next = new ListNode(d);
    }

    void insert(ListNode head, int d, int k) {
        for (int i = 0; i < k - 1; i++) {
            if (head.next != null) {
                head = head.next;
            } else {
                return;
            }
        }
        ListNode next = head.next;
        head.next = new ListNode(d);
        head.next.next = next;
    }

    public ListNode merge(ListNode node1, ListNode node2) {
        if (node1 == null) {
            return node2;
        }
        if (node2 == null) {
            return node1;
        }

        int val1 = node1.val;
        int val2 = node2.val;
        ListNode head;
        if (val1 < val2) {
            head = node1;
            node1 = node1.next;
        } else {
            head = node2;
            node2 = node2.next;
        }
        System.out.println("headval: " + head.val);

        ListNode ptr = head;
        while (node1 != null && node2 != null) {
            val1 = node1.val;
            val2 = node2.val;
            if (val1 < val2) {
                System.out.println("n1");
                ptr.next = node1;
                node1 = node1.next;
            } else {
                System.out.println("n2");
                ptr.next = node2;
                node2 = node2.next;
            }
            ptr = ptr.next;
        }

        if (node1 != null) {
            ptr.next = node1;
        }
        if (node2 != null) {
            ptr.next = node2;
        }

        return head;
    }

    public static void main(String[] args) {
        LinkedList l = new LinkedList();
        ListNode head = ListNode.makeList();
        ListNode head2 = ListNode.makeList();

        l.insert(head, 123);
        l.insert(head, 456, 2);
        ListNode.printList(head);

        ListNode merged = l.merge(head, head2);
        System.out.println("merged: ");
        ListNode.printList(merged);
    }
}
