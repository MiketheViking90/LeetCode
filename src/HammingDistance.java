import java.util.Arrays;

public class HammingDistance {

    public int getHammingDistance(int x, int y) {
        int[] xBinaryArray = getBinaryArray(x);
        int[] yBinaryArray = getBinaryArray(y);

        int distance = 0;
        for (int i = 0; i < 32; i++) {
            if (xBinaryArray[i] != yBinaryArray[i]) {
                distance++;
            }
        }
        return distance;
    }

    private int[] getBinaryArray(int n) {
        int[] binaryArray = new int[32];

        for (int i = 0; i < 32; i++) {
            int bitMask = (1 << i);
            int getBit = (n & bitMask);

            if (getBit != 0) {
                binaryArray[32-i-1] = 1;
            } else {
                binaryArray[32-i-1] = 0;
            }
        }
        return binaryArray;
    }

    public static void main(String[] args) {
        int x = 12;
        int y = 8;

        HammingDistance hd = new HammingDistance();
        int[] xAry = hd.getBinaryArray(x);
        int[] yAry = hd.getBinaryArray(y);

        System.out.println(Arrays.toString(xAry));
        System.out.println(Arrays.toString(yAry));
    }
}
