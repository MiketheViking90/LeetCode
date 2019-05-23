package eighteen.algo;

import java.util.PriorityQueue;

public class KthLargestElementInArray {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);

        for (int n : nums) {
            if (pq.size() < k) {
                pq.offer(n);
            } else {
                if (n > pq.peek()) {
                    pq.poll();
                    pq.offer(n);
                }
            }
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        KthLargestElementInArray kth = new KthLargestElementInArray();
        int[] ns = {3,2,1,5,6,4};
        int k = kth.findKthLargest(ns, 2);
        System.out.println(k);
    }
}