package archive.algorithms;

import archive.domain.ListNode;

public class DeleteNodeInLinkedList {

    public void deleteNode(ListNode node) {
        if (node.next == null) {
            return;
        }

        while (node.next != null) {
            node.val = node.next.val;

            if (node.next.next == null) {
                node.next = null;
                return;
            }
            node = node.next;
        }
    }

    public static void main(String[] args) {
        ListNode example = ListNode.makeList();
        ListNode.printList(example);

        DeleteNodeInLinkedList del = new DeleteNodeInLinkedList();
        del.deleteNode(example.next.next);
        ListNode.printList(example);
    }

}