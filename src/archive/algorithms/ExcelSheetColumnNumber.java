package archive.algorithms;

public class ExcelSheetColumnNumber {

    public int titleToNumber(String s) {
        int len = s.length();
        int sum = 0;

        for (int i = 0; i < len; i++) {
            sum += getVal(len - i - 1, s.charAt(i));
        }

        return sum;
    }

    private int getVal(int i, char c) {
        int digit = c - 64;
        int power = getPower(i);
        return digit * power;
    }

    private int getPower(int i) {
        if (i == 0) {
            return 1;
        }
        int val = 26;
        for (int j = 1; j < i; j++) {
            val *= 26;
        }
        return val;
    }

    public static void main(String[] args) {
        ExcelSheetColumnNumber es = new ExcelSheetColumnNumber();
        int val = es.titleToNumber("AA");
        System.out.println(val);
    }
}
