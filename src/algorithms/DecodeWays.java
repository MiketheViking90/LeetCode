package algorithms;

public class DecodeWays {
    public int numDecodings(String s) {
        int len = s.length();
        int[] mem = new int[len+1];
        if (s.charAt(0) == '0') {
            return 0;
        }
        mem[1] = 1;

        for (int i = 2; i <= len; i++) {
            int curChar = s.charAt(i-1) - '0';
            int prevChar = s.charAt(i-2) - '0';
            if (curChar == 0) {
                if (prevChar == 1 || prevChar == 2) {
                    mem[i] = mem[i-1];
                } else {
                    return 0;
                }
            } else if ((prevChar == 2 && curChar <= 6) || (prevChar == 1)) {
                mem[i] = mem[i-1] + 1;
            } else {
                mem[i] = mem[i-1];
            }
        }
        return mem[len];
    }
}
