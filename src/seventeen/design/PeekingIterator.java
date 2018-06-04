package seventeen.design;

import java.util.Iterator;

class PeekingIterator implements Iterator<Integer> {

    Iterator<Integer> iterator;
    Integer next = null;

    public PeekingIterator(Iterator<Integer> iterator) {
        this.iterator = iterator;
        if (iterator.hasNext()) {
            this.next = iterator.next();
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return next;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        next = iterator.next();
        return next;
    }

    @Override
    public boolean hasNext() {
        return next != null;
    }
}