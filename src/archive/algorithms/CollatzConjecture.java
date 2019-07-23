package archive.algorithms;

public class CollatzConjecture {
    public int maxSteps(int n) {
        int max = 1;
        for (int i = 2; i <= n; i++) {
            int steps = countSteps(i);
            max = Math.max(steps, max);
        }
        return max;
    }

    private int countSteps(int i) {
        int cnt = 0;
        while (i != 1) {
            if (i % 2 == 0) {
                i /= 2;
            } else {
                i = (3*i)+1;
            }
            cnt++;
        }
        return cnt;
    }
}
