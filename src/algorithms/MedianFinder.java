package algorithms;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFinder {

    private PriorityQueue<Integer> minElts;
    private PriorityQueue<Integer> maxElts;

    public MedianFinder() {
        minElts = new PriorityQueue<>(Comparator.reverseOrder());
        maxElts = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (minElts.size() == 0 && maxElts.size() == 0) {
            maxElts.offer(num);
            return;
        }

        if (minElts.size() == maxElts.size()) {
            if (num <= minElts.peek()) {
                minElts.add(num);
            } else {
                maxElts.add(num);
            }
        } else if (minElts.size() < maxElts.size()) {
            if (num >= maxElts.peek()) {
                int poll = maxElts.poll();
                minElts.offer(poll);
                maxElts.offer(num);
            } else {
                minElts.offer(num);
            }
        } else {
            if (num <= minElts.peek()) {
                int poll = minElts.poll();
                maxElts.offer(poll);
                minElts.offer(num);
            } else {
                maxElts.offer(num);
            }
        }
    }

    public double findMedian() {
        if (minElts.isEmpty() && maxElts.isEmpty()) {
            return 0;
        }
        if (maxElts.isEmpty()) {
            return minElts.peek();
        }
        if (minElts.isEmpty()) {
            return maxElts.peek();
        }

        if (minElts.size() == maxElts.size()) {
            return ((double) minElts.peek() + maxElts.peek()) / 2.0;
        } else {
            PriorityQueue<Integer> pq = maxElts.size() > minElts.size() ? maxElts : minElts;
            return new Double(pq.peek());
        }
    }

    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();
        mf.addNum(1);
        mf.addNum(2);
        mf.addNum(3);
        System.out.println(mf.findMedian());
    }
}
