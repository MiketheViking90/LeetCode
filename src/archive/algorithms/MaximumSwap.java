package archive.algorithms;

import java.util.HashMap;
import java.util.Map;

public class MaximumSwap {

    public int maximumSwap(int num) {
        int[] digits = toDigitArray(num);
        int n = digits.length;
        Map<Integer, Integer> digitToLastIndex = new HashMap<>();

        int[] maxAfter = new int[n];
        int curMax = digits[n-1];
        digitToLastIndex.put(curMax, n-1);

        for (int i = n-2; i >= 0 ; i--) {
            int curNum = digits[i];
            if (curNum >= curMax) {
                maxAfter[i] = -1;
                if (!digitToLastIndex.containsKey(curNum)) {
                    digitToLastIndex.put(curNum, i);
                }
                curMax = curNum;
            } else {
                maxAfter[i] = curMax;
            }
        }

        for (int i = 0; i < n; i++) {
            if (digits[i] < maxAfter[i]) {
                int max = maxAfter[i];
                int index = digitToLastIndex.get(max);
                digits[index] = digits[i];
                digits[i] = max;
                return toNum(digits);
            }
        }

        return num;
    }

    private int[] toDigitArray(int num) {
        char[] charArray = String.valueOf(num).toCharArray();
        int[] digitAry = new int[charArray.length];
        for (int i = 0; i < charArray.length; i++) {
            int n = charArray[i] - '0';
            digitAry[i] = n;
        }

        return digitAry;
    }

    private int toNum(int[] digitAry) {
        int power = 0;
        int num = 0;
        for (int i = digitAry.length-1; i >= 0; i--) {
            int curDigit = (int) (digitAry[i] * Math.pow(10, power));
            power++;

            num += curDigit;
        }

        return num;
    }

    public static void main(String[] args) {
        MaximumSwap ms = new MaximumSwap();
        int swap = ms.maximumSwap(98368);
        System.out.println(swap);
    }
}
