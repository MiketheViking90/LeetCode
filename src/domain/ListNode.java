package domain;

public class ListNode {

    public int val;
    public ListNode next;

    public ListNode(int x) {
        this.val = x;
    }

    public static ListNode makeList() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        return n1;
    }

    public static void printList(ListNode n1) {
        StringBuffer val = new StringBuffer();

        while (n1 != null) {
            val.append(n1.val + ">");
            n1 = n1.next;
        }

        System.out.println(val);
    }

}
