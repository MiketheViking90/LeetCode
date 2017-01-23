package algorithms;

public class ArrayAddOne {

    int[] plusOne(int[] val) {
        boolean isCarry = false;
        int i = val.length - 1;
        while (i >= 0) {
            int digit = val[i];

            if (digit != 9) {
                val[i]++;
                return val;
            } else {
                val[i] = 0;
                i--;
            }
        }
        int[] res = new int[val.length + 1];
        res[0] = 1;
        return res;
    }


    public static void main(String[] args) {
        ArrayAddOne a = new ArrayAddOne();
        int[] val = new int[]{1,2,3,9};
        int[] val1 = new int[]{3,9};
        int[] res = a.plusOne(val);
    }
}
