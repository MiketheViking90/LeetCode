package archive.algorithms;

import archive.domain.ListNode;

public class DeleteKthFromLast {

    public void deleteKthFromLast(ListNode head, int k) {
        ListNode cur = head;
        ListNode run = head;

        int cnt = k;
        while (cnt > 0 && run != null) {
            run = run.next;
            cnt--;
        }

        while (run.next != null) {
            cur = cur.next;
            run = run.next;
        }

        if (k == 1) {
            cur.next = null;
        } else {
            cur.next = run;
        }

    }

    public static void main(String[] args) {
        ListNode head = ListNode.makeList();
        DeleteKthFromLast del = new DeleteKthFromLast();
        del.deleteKthFromLast(head, 1);

        ListNode.printList(head);
    }
}
