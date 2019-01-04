package eighteen.algo;

import seventeen.domain.ListNode;

public class MiddleOfTheLinkedList {
    public ListNode middleNode(ListNode head) {
        int n = 0;
        ListNode slow = head;
        while (head != null) {
            slow = slow.next;
            head = head.next;
            if (head == null) {
                return slow;
            }
            head = head.next;
        }
        return slow;
    }
}
