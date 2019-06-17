package archive.algorithms;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>(rowIndex + 1);
        if (rowIndex == 0) {
            row.add(1);
            return row;
        }
        long[] factorials = new long[rowIndex+1];
        factorials[0] = 1;
        factorials[1] = 1;
        for (int i = 2; i < rowIndex + 1; i++) {
            factorials[i] = i * factorials[i-1];
        }
        
        for (int i = 0; i < rowIndex + 1; i++) {
            int n = getCombos(i, rowIndex, factorials);
            row.add(n);
        }

        return row;
    }

    private int getCombos(int r, int n, long[] factorials) {
        long numerator = factorials[n];
        long denominator = factorials[r] * factorials[n-r];

        return (int) (numerator/denominator);
    }

    public static void main(String[] args) {
        PascalTriangle pt = new PascalTriangle();
        System.out.println(pt.getRow(1));
        System.out.println(pt.getRow(2));
        System.out.println(pt.getRow(3));
        System.out.println(pt.getRow(4));
        System.out.println(pt.getRow(5));
        System.out.println(pt.getRow(6));
        System.out.println(pt.getRow(7));
        System.out.println(pt.getRow(8));
        System.out.println(pt.getRow(9));
        System.out.println(pt.getRow(10));
        System.out.println(pt.getRow(11));
        System.out.println(pt.getRow(12));
        System.out.println(pt.getRow(13));
    }
}
