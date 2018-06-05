package eighteen.algo;

import seventeen.domain.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {

    ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }

        Comparator<ListNode> compareListNodes = (ListNode n1, ListNode n2) -> {
            return n1.val - n2.val;
        };

        PriorityQueue<ListNode> listQueue = new PriorityQueue<>(compareListNodes);
        for (ListNode list : lists) {
            if (list != null) {
                listQueue.offer(list);
            }
        }

        ListNode head = null;
        ListNode cur = null;
        while (!listQueue.isEmpty()) {
            ListNode top = listQueue.poll();
            if (head == null) {
                head = top;
                cur = top;
            } else {
                cur.next = top;
                cur = cur.next;
            }

            top = top.next;
            if (top != null) {
                listQueue.offer(top);
            }
        }

        return head;
    }

}
