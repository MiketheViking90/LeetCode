public class FindTheDifference {

    public char findTheDifference(String s, String t) {
        char diff = 0;
        for (char c : s.toCharArray()) {
            diff ^= c;
        }
        for (char c : t.toCharArray()) {
            diff ^= c;
        }
        return diff;
    }

    public static void main(String[] args) {
        FindTheDifference fd = new FindTheDifference();
        String s = "abcd";
        String t = "abcde";
        char c = fd.findTheDifference(s, t);
        System.out.println(c);
    }
}
