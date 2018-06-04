package seventeen.algorithms;

import seventeen.domain.ListNode;

public class PartitionAround {

    public ListNode paritionAround(ListNode head, int val) {
        ListNode beginStart = null;
        ListNode beginCur = null;
        ListNode endStart = null;
        ListNode endCur = null;
        ListNode cur = head;

        while (cur != null) {
            System.out.println(cur.val);
            ListNode next = cur.next;
            if (cur.val > val) {
                if (beginStart == null) {
                    System.out.println("\tbeginStart " + cur.val);
                    beginStart = cur;
                    beginCur = cur;
                } else {
                    System.out.println("\tbeginNext " + cur.val);
                    beginCur.next = cur;
                    beginCur = beginCur.next;
                }
                ListNode.printList(beginStart);
            } else {
                if (endStart == null) {
                    System.out.println("\tendStart " + cur.val);
                    endStart = cur;
                    endCur = cur;
                } else {
                    System.out.println("\tendNext " + cur.val);
                    endCur.next = cur;
                    endCur = endCur.next;
                }
            }
            cur.next = null;
            cur = next;
        }

        beginCur.next = endStart;
        return beginStart;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(4);
        ListNode n4 = new ListNode(1);
        ListNode n5 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        PartitionAround part = new PartitionAround();
        ListNode res = part.paritionAround(n1, 4);
        ListNode.printList(res);
    }
}
