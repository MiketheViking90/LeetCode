package algorithms;

public class NumberOfSegmentsInString {

    public int countSegments(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int cnt = 0;
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) != ' ') {
                cnt++;
                while (i < s.length() && s.charAt(i) != ' ') {
                    i++;
                }
            } else {
                while (i < s.length() && s.charAt(i) == ' ') {
                    i++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        String s = "                ";
        NumberOfSegmentsInString ns = new NumberOfSegmentsInString();
        System.out.println(ns.countSegments(s));
    }
}
