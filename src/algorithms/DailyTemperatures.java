package algorithms;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] T) {
        int N = T.length;
        int[] waits = new int[N];

        Deque<Integer> prevMaxIdx = new LinkedList<>();
        for (int i = N-1; i >= 0; i--) {
            int t = T[i];
            while (!prevMaxIdx.isEmpty() && T[prevMaxIdx.peek()] <= t) {
                prevMaxIdx.pop();
            }

            if (!prevMaxIdx.isEmpty()) {
                waits[i] = prevMaxIdx.peek() - i;
            }
            prevMaxIdx.push(i);
        }

        return waits;
    }

    public static void main(String[] args) {
        DailyTemperatures dt = new DailyTemperatures();
        int[] temps = {3, 4, 5, 1, 0, 2, 6, 3};
        int[] waits = dt.dailyTemperatures(temps);
        System.out.println(Arrays.toString(waits));
    }
}
