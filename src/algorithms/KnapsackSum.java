package algorithms;

import java.util.Arrays;

public class KnapsackSum {

    private int[][] mem;
    private int[] weights;
    private int capacity;

    public KnapsackSum(int[] rocks, int weight) {
        int n = rocks.length;
        mem = new int[n + 1][weight + 1];

        this.weights = rocks;
        this.capacity = weight;
    }

    public void findSum() {
        int numRocks = weights.length;
        for (int i = 1; i < numRocks; i++) {
            int curWeight = weights[i];

            for (int w = 1; w <= capacity; w++) {
                System.out.println(curWeight + ", " + capacity);
                if (curWeight > w) {
                    mem[i][w] = mem[i-1][w];
                } else {
                    int include = curWeight + mem[i - 1][w - curWeight];
                    int uninclude = mem[i - 1][w];
                    mem[i][w] = Math.max(include, uninclude);
                }
            }
        }

        System.out.println(Arrays.deepToString(mem));
    }

    public static void main(String[] args) {
        int[] nums = {2, 5, 2, 1, 6, 5, 7};
        int n = 7;

        KnapsackSum ks = new KnapsackSum(nums, n);
        ks.findSum();
    }
}
