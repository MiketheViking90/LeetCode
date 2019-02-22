package eighteen.algo;

public class FlipStringToMonotoneIncreasing {
    public int minFlipsMonoIncr(String S) {
        char[] cAry = S.toCharArray();
        int i = 0;
        int j = S.length()-1;

        int flips = 0;
        while (i < j) {
            char a = cAry[i];
            char b = cAry[j];

            if (a == '0' && b == '1') {
                i++;
                j--;
            } else if (a == '0' && b == '0') {
                i++;
            } else if (a == '1' && b == '0') {
                cAry[i] = '0';
                cAry[j] = '1';
                i++;
                j--;
                flips++;
            } else {
                j--;
            }
        }
        return flips;
    }

    public static void main(String[] args) {
        FlipStringToMonotoneIncreasing fs = new FlipStringToMonotoneIncreasing();
        int a = fs.minFlipsMonoIncr("010110");
        System.out.println(a);
    }
}
