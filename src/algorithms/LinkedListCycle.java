package algorithms;

import archive.domain.ListNode;

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null) {
            if (slow == fast) {
                return true;
            }
            fast = fast.next;
            if (fast == null) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return false;
    }
}
