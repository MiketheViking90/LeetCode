package seventeen.algorithms;

public class RepeatedSubstringPattern {

    public boolean repeatedSubstringPattern(String s) {

        int len = s.length();
        for (int i = 1; i <= len/2; i++) {
            if (len % i == 0) {
                String subString = s.substring(0, i);

                StringBuffer sb = new StringBuffer();
                for (int j = 0; j < (len/i); j++) {
                    sb.append(subString);
                    String compareTo = s.substring(0, (j+1)*i);
                    if (!sb.toString().equals(compareTo)) {
                        break;
                    }
                }

                if (sb.toString().equals(s)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "abcabc";
        RepeatedSubstringPattern rsp = new RepeatedSubstringPattern();
        boolean b = rsp.repeatedSubstringPattern(s);
        System.out.println(b);
    }
}
