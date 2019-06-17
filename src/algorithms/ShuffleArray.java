package algorithms;

import java.util.Random;

public class ShuffleArray {

    int[] original;
    int[] copy;
    Random random = new Random();

    public ShuffleArray(int[] nums) {
        original = nums;
        int N = original.length;
        copy = new int[N];
        for (int i = 0; i < N; i++) {
            copy[i] = original[i];
        }
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        int N = original.length;
        for (int i = 0; i < N; i++) {
            copy[i] = original[i];
        }
        return original;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        for (int i = 0; i < original.length; i++) {
            swapRandom(i, original.length, copy);
        }
        return copy;
    }

    private void swapRandom(int min, int max, int[] ary) {
        int nextIdx = random.nextInt(max - min) + min;
        int tmp = ary[min];
        ary[min] = ary[max];
        ary[max] = tmp;
    }
}
