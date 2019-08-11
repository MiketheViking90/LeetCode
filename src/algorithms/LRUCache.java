package algorithms;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class LRUCache {
    private int N = 3;
    private int size = 0;

    private final Map<String, DoubleLinkedNode> keyToNode = new HashMap<>();
    private DoubleLinkedNode head;

    public void put(String key, int value) {
        DoubleLinkedNode newHead = new DoubleLinkedNode(key, value);
        size++;

        if (size == 1) {
            newHead.next = newHead;
            newHead.prev = newHead;
        } else {
            DoubleLinkedNode tail = getTail(head);
            newHead.next = head;
            newHead.prev = tail;
            head.prev = newHead;
            tail.next = newHead;
        }

        keyToNode.put(key, newHead);
        head = newHead;
    }

    private DoubleLinkedNode getTail(DoubleLinkedNode head) {
        if (size > N) {
            String removeKey = head.prev.k;
            keyToNode.remove(removeKey);
            size--;
            return head.prev.prev;
        }
        return head.prev;
    }

    public int get(String key) {
        DoubleLinkedNode node = keyToNode.get(key);

        DoubleLinkedNode prev = node.prev;
        DoubleLinkedNode next = node.next;

        prev.next = next;
        next.prev = prev;

        DoubleLinkedNode tail = head.prev;

        node.next = head;
        head.prev = node;

        node.prev = tail;
        tail.next = node;

        head = node;

        return node.v;
    }
}
