package seventeen.algorithms;

import java.util.Arrays;

public class ArrayLeftRotation {

    public int[] rotate(int[] array, int d) {
        int len = array.length;
        int offset = d % len;

//        for (int i = 0; i < offset; i++) {
//            shiftByOne(array);
//        }
        //return array;
        int[] rotated = new int[len];
        for (int i = 0; i < len; i++) {
            int j = (i + offset) % len;
            System.out.println(j + ", " + array[j]);
            rotated[i] = array[j];
        }
        return rotated;
    }

    private void shiftByOne(int[] array) {
        int len = array.length;
        int lastVal = array[len - 1];

        int cur = array[0];
        int next = cur;
        for (int i = 1; i < len; i++) {
            next = array[i];
            array[i] = cur;
            cur = next;
        }
        array[0] = lastVal;
    }

    public static void main(String[] args) {
        ArrayLeftRotation sol = new ArrayLeftRotation();
        int[] ary = {1,2,3,4,5};
        ary = sol.rotate(ary, 6);
        System.out.println(Arrays.toString(ary));
    }
}
