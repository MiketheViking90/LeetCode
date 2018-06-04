package seventeen.algorithms;

import java.util.Arrays;

public class CountingBits {

    public int[] countBits(int num) {
        int len = num+1;
        int[] bitCounts = new int[len];
        for (int i=0; i<len; i++) {
            bitCounts[i] = numBits(i);
        }
        return bitCounts;
    }

    private int numBits(int n) {
        String binaryString = Integer.toBinaryString(n);

        int cnt = 0;
        for (int i=0; i<binaryString.length(); i++) {
            if (binaryString.charAt(i) == '1') {
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        CountingBits cb = new CountingBits();
        int[] bits = cb.countBits(8);
        System.out.println(Arrays.toString(bits));
    }

}
