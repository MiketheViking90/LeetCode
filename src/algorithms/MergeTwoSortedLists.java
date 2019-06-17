package algorithms;

import archive.domain.ListNode;

public class MergeTwoSortedLists {

    ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode head;
        if (l1.val < l2.val) {
            head = l1;
            l1 = l1.next;
        } else {
            head = l2;
            l2 = l2.next;
        }
        ListNode cur = head;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                cur = cur.next;
                l1 = l1.next;
            } else {
                cur.next = l2;
                cur = cur.next;
                l2 = l2.next;
            }
        }

        if (l1 != null) cur.next = l1;
        if (l2 != null) cur.next = l2;

        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = ListNode.makeList();
        ListNode l2 = ListNode.makeList();

        MergeTwoSortedLists mt = new MergeTwoSortedLists();
        ListNode head = mt.mergeTwoLists(l1, l2);
        ListNode.printList(head);
    }
}
