package archive.design;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class LRUCache {

    private final Map<String, Double> isbnToPrice = new HashMap<>();
    private final Queue<String> lookupQueue = new LinkedList<>();
    private final int capacity;
    private int curSize = 0;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public void add(Book book) {
        String isbn = book.isbn;
        isbnToPrice.putIfAbsent(isbn, book.price);
        lookupQueue.offer(isbn);

        if (curSize++ == capacity) {
            String removed = lookupQueue.poll();
            isbnToPrice.remove(removed);
            curSize--;
        }
    }

    public double lookUp(String isbn) {
        if (!isbnToPrice.containsKey(isbn)) {
            return -1;
        }

        lookupQueue.remove(isbn);
        lookupQueue.offer(isbn);
        return isbnToPrice.get(isbn);
    }

    public void print() {
        System.out.println(lookupQueue);
        System.out.println(isbnToPrice);
        System.out.println();
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);

        Book book1 = new Book("a123", 9.99);
        Book book2 = new Book("b123", 19.99);
        Book book3 = new Book("c123", 29.99);
        Book book4 = new Book("d123", 39.99);
        Book book5 = new Book("e123", 49.99);

        cache.add(book1);
        cache.add(book2);
        cache.print();
        cache.add(book3);
        cache.add(book4);
        cache.add(book5);
        cache.print();
    }

}
