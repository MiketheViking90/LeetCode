package archive.algorithms;

import java.util.PriorityQueue;

public class MedianFinder {

    PriorityQueue<Integer> minPQ;
    PriorityQueue<Integer> maxPQ;

    public MedianFinder() {
        minPQ = new PriorityQueue<>();
        maxPQ = new PriorityQueue<>(
            (Integer a, Integer b) -> Integer.compare(a, b) * -1
        );
    }

    public void addNum(int num) {
        if (maxPQ.size() == 0 && minPQ.size() == 0) {
            minPQ.add(num);
        } else if (maxPQ.size() < minPQ.size()) {
            if (num < minPQ.peek()) {
                maxPQ.add(num);
            } else {
                maxPQ.add(minPQ.poll());
                minPQ.add(num);
            }
        } else {
            if (num > maxPQ.peek()) {
                minPQ.add(num);
            } else {
                minPQ.add(maxPQ.poll());
                maxPQ.add(num);
            }
        }
    }

    public double findMedian() {
        if (maxPQ.size() == minPQ.size()) {
            return (maxPQ.peek() + minPQ.peek()) / 2.;
        } else {
            return maxPQ.size() > minPQ.size() ? maxPQ.peek() : minPQ.peek();
        }
    }
}
