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

    int mask(int n) {
        return (~0 << n);
    }

    public static void main(String[] args) {
        BitManipulation bm = new BitManipulation();
        int val = 13;
        System.out.println(toBinaryString(val));

        int setBit = bm.setBit(val, 1);
        System.out.println(toBinaryString(setBit));

        int mask = bm.mask(3);
        System.out.println(toBinaryString(mask));

        int clearBit = bm.clearBit(val, 2);
        System.out.println(toBinaryString(clearBit));
    }
}
