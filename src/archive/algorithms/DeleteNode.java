package archive.algorithms;

import archive.domain.ListNode;

public class DeleteNode {

    public void deleteNode(ListNode head, int d) {

        ListNode node = head;
        while (node.next != null) {
            if (node.next.val == d) {
                node.next = node.next.next;
                return;
            }
            node = node.next;
        }
    }

    public static void main(String[] args) {
        ListNode head = ListNode.makeList();
        DeleteNode dn = new DeleteNode();

        dn.deleteNode(head, 5);
        ListNode.printList(head);
    }
}
