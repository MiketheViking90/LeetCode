import static java.lang.Integer.*;

public class BitManipulation {

    int getBit(int num, int i) {
        int bitToGet = (1 << i);
        return num & 1;
    }

    int setBit(int num, int i) {
        int bitToSet = 1 << i;
        return (num | bitToSet);
    }

    int clearBit(int num, int i) {
        int mask = ~(1 << i);
        return num & mask;
    }

    int swapBits(int num, int i, int j) {
        int mask = (1 << i ) | (1 << j);
        System.out.println(toBinaryString(mask));
        return num ^= mask;
    }

    int complement(int n) {
        int maxSetBit = 0;
        int i = 32;
        while (i > 0) {
            if ((n >> i) == 1) {
                maxSetBit = i;
            }
            i--;
        }
        int mask = (1 << (maxSetBit + 1)) - 1;
        System.out.println(toBinaryString(mask));
        return n ^ mask;
    }

    int mask(int n) {
        return (~0 << n);
    }

    public static void main(String[] args) {
        BitManipulation bm = new BitManipulation();
//        int val = 13;
//        System.out.println(toBinaryString(val));
//
//        int setBit = bm.setBit(valasdfafda, 1);
//        System.out.println(toBinaryString(setBit));
//
//        int mask = bm.mask(3);
//        System.out.println(toBinaryString(mask));
//asdfadsf
//        int clearBit = bm.clearBit(val, 2);
//        System.out.println(toBinaryString(clearBit));

        System.out.println(toBinaryString(77));
        System.out.println(toBinaryString(bm.complement(77)));
    }
}
