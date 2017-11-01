package algorithms;

import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedianDataStream {

    PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> minPQ = new PriorityQueue<>();
    int size = 0;

    public void add(int n) {
        size++;

        maxPQ.offer(n);
        int max = maxPQ.poll();
        minPQ.offer(max);

        if (maxPQ.size() < minPQ.size()) {
            maxPQ.offer(minPQ.poll());
        }
    }

    public double getMedian() {
        if (size % 2 == 0) {
            int m1 = maxPQ.peek();
            int m2 = minPQ.peek();

            return (m1 + m2) / 2;
        }

        return maxPQ.peek();
    }

    public static void main(String[] args) {
        FindMedianDataStream med = new FindMedianDataStream();
        med.add(3);
        med.add(1);
        med.add(4);
        System.out.println(med.getMedian());
        med.add(1);
        System.out.println(med.getMedian());
        med.add(5);
        med.add(9);
        System.out.println(med.getMedian());
    }
}
