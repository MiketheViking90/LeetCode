package archive.algorithms;

import archive.domain.ListNode;

public class ReverseList {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = head;
        ListNode cur = head.next;
        ListNode next = head.next.next;
        prev.next = null;
        while (next != null) {
            cur.next = prev;
            prev = cur;
            cur = next;
            next = next.next;
        }
        cur.next = prev;
        return cur;
    }

    public static void main(String[] args) {
        ReverseList rv = new ReverseList();
        ListNode test = ListNode.makeList();
        ListNode val = rv.reverseList(test);
        ListNode.printList(val);
    }
}
