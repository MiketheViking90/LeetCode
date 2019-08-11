package algorithms;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class LRUCacheTest {

    @Test
    public void testPut() {
        LRUCache lru = new LRUCache();
        lru.put("a", 1);
        System.out.println("a");
        printList(lru);

        lru.put("b", 2);
        System.out.println("b -> a");
        printList(lru);

        lru.put("c", 3);
        System.out.println("c -> b -> a");
        printList(lru);

        System.out.println("get");
        lru.get("a");
        System.out.println("a -> c -> b");
        printList(lru);

        lru.put("d", 4);
        System.out.println("d -> a -> c");
        printList(lru);

        lru.put("e", 5);
        System.out.println("e -> d -> a");
        printList(lru);
    }

    private void printList(LRUCache lru) {
        int size = lru.getSize();
        DoubleLinkedNode node = lru.getHead();

        for (int i = 0; i < 5; i++) {
            if (node != null) {
                //System.out.println(node);
                System.out.println(node.k + ", " + node.v);
                node = node.next;
            }
        }
    }

    @Test
    public void testGet() {
    }
}