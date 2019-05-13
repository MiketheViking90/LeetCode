package eighteen.algo;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FindMedianFromDataStream {

    Comparator<Integer> reverseIntCompare = (Integer a, Integer b) -> (b-a);
    PriorityQueue<Integer> minVals = new PriorityQueue<>(reverseIntCompare);
    PriorityQueue<Integer> maxVals = new PriorityQueue<>();

    public void add(int n) {
//        if (minVals.size() == maxVals.size()) {
//            minVals.offer(n);
//        } else if (minVals.size() > maxVals.size()) {
//            if (n < maxZVals)
//        } else {
//
//        }
    }

    public double findMedian() {
        return 0;
    }
}
