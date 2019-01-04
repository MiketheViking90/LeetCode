package eighteen.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShortestDistanceToACharacter {
    public int[] shortestToChar(String S, char C) {
        List<Integer> loc = new ArrayList<>();
        int len = S.length();
        for (int i = 0; i < len; i++) {
            if (S.charAt(i) == C) {
                loc.add(i);
            }
        }

        int p = 0, n = 0;
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            int prev = loc.get(p);
            int next = loc.get(n);

            res[i] = Math.min(Math.abs(i - prev), Math.abs(next - i));
            if (i == next) {
                if (p == loc.size() - 1 && n == loc.size() -1) {

                } else if (p == n) {
                    n++;
                } else if (n == loc.size()-1) {
                    p++;
                } else {
                    p++;
                    n++;
                }
            }
        }
        return res;
    }

    public int[] shortestToChar1(String S, char C) {
        int len = S.length();
        int[] lMin = new int[len];
        int[] rMin = new int[len];

        int prev = -len;
        for (int i = 0; i < len; i++) {
            if (S.charAt(i) == C) {
                lMin[i] = 0;
                prev = i;
            } else {
                lMin[i] = i - prev;
            }
        }

        prev = 2*len;
        for (int i = len-1; i >= 0; i--) {
            if (S.charAt(i) == C) {
                rMin[i] = 0;
                prev = i;
            } else {
                rMin[i] = prev - i;
            }
        }

        int[] min = new int[len];
        for (int i = 0; i < len; i++) {
            min[i] = Math.min(lMin[i], rMin[i]);
        }
        return min;
    }

    public static void main(String[] args) {
        ShortestDistanceToACharacter sd = new ShortestDistanceToACharacter();
        int[] vs = sd.shortestToChar1("abaa", 'b');
        System.out.println(Arrays.toString(vs));
    }
}
