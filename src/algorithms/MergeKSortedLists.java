package algorithms;

import domain.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> queue = new PriorityQueue<>(listNodeComparator);
        for (ListNode node : lists) {
            queue.add(node);
        }

        ListNode head = queue.poll();
        ListNode tail = head;

        queue.add(head.next);

        while (!queue.isEmpty()) {
            ListNode ptr = queue.poll();
            tail.next = ptr;
            tail = tail.next;

            if (ptr.next != null) {
                queue.add(ptr.next);
            }
        }

        ListNode.printList(head);
        return head;
    }

    private Comparator<ListNode> listNodeComparator =
            (ListNode o1, ListNode o2) -> {
                int val1 = o1.val;
                int val2 = o2.val;
                return Integer.compare(val1, val2);
            };

    public static void main(String[] args) {
        MergeKSortedLists mksl = new MergeKSortedLists();

        ListNode l1 = ListNode.makeList();
        ListNode l2 = ListNode.makeList();

        ListNode[] lists = {l1, l2};
        mksl.mergeKLists(lists);
    }
}
