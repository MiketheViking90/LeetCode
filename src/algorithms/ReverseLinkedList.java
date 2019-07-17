package algorithms;

import archive.domain.ListNode;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = head;
        ListNode cur = head.next;
        ListNode next = head.next.next;
        prev.next = null;

        while (cur != null) {
            cur.next = prev;
            if (next == null) {
                return cur;
            }

            prev = cur;
            cur = next;
            next = next.next;
        }
        return cur;
    }

    public static void main(String[] args) {
        ListNode node = ListNode.makeList();
        ReverseLinkedList rll = new ReverseLinkedList();
        ListNode node1 = rll.reverseList(node);
        ListNode.printList(node1);
    }
}
