package algorithms;

import java.util.PriorityQueue;

public class KthSmallestSortedMatrix {

    private class IndexedArray implements Comparable<IndexedArray> {

        public int index;
        public int[] nums;

        public IndexedArray(int[] nums) {
            this.index = 0;
            this.nums = nums;
        }

        @Override
        public int compareTo(IndexedArray o) {
            int val = nums[index];
            int compareTo = o.nums[o.index];
            return Integer.compare(val, compareTo);
        }
    }

    public int kthSmallest(int[][] matrix, int k) {
        int rows = matrix.length;
        int len = matrix[0].length;
        PriorityQueue<IndexedArray> pq = new PriorityQueue<>(rows);

        for (int[] row : matrix) {
            IndexedArray ia = new IndexedArray(row);
            pq.add(ia);
        }

        while (k > 1) {
            IndexedArray ia = pq.poll();
            int i = ia.index;
            if (i != len - 1) {
                ia.index++;
                pq.add(ia);
            }
            k--;
        }

        IndexedArray sol = pq.poll();
        int i = sol.index;
        return sol.nums[i];
    }

    public static void main(String[] args) {
        int[][] matrix =
                {
                    { 1,  5,  9},
                    {10, 11, 13},
                    {12, 13, 15}
                };
        int index = 8;

        KthSmallestSortedMatrix ks = new KthSmallestSortedMatrix();
        int val = ks.kthSmallest(matrix, index);
        System.out.println(val);
    }
}
