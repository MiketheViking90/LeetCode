package seventeen.algorithms;

import seventeen.domain.ListNode;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesListNode {

    public void removeDuplicatesBuffer(ListNode head) {
        Set<Integer> values = new HashSet<>();

        ListNode node = head;
        values.add(head.val);
        while (node.next != null) {
            int nextVal = node.next.val;
            if (values.contains(nextVal)) {
                node.next = node.next.next;
            } else {
                values.add(nextVal);
                node = node.next;
            }
        }
    }

    public void removeDuplicates(ListNode head) {
        ListNode cur = head;

        while (cur != null) {
            int curVal = cur.val;

            ListNode run = cur;
            while (run.next != null) {
                if (run.next.val == curVal) {
                    run.next = run.next.next;
                } else {
                    run = run.next;
                }
            }
            cur = cur.next;
        }
    }

    public static void main(String[] args) {
        ListNode head = ListNode.makeList();
        ListNode.append(head, 5);
        ListNode.append(head, 3);
        ListNode.append(head, 4);
        ListNode.printList(head);

        RemoveDuplicatesListNode rm = new RemoveDuplicatesListNode();
        rm.removeDuplicates(head);
        //rm.removeDuplicatesBuffer(head);
        ListNode.printList(head);
    }
}
