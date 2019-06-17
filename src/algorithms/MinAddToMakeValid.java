package algorithms;

public class MinAddToMakeValid {

    public int minAddToMakeValid(String s) {
        int n = 0;
        int lVal = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                lVal++;
            } else {
                if (lVal > 0) {
                    lVal--;
                } else {
                    n++;
                }
            }
        }

        return n + lVal;
    }

    public static void main(String[] args) {
        String s = "()";
        MinAddToMakeValid ma = new MinAddToMakeValid();
        int n = ma.minAddToMakeValid(s);
        System.out.println(n);
    }

}
