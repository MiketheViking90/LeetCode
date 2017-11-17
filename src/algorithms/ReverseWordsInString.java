package algorithms;

public class ReverseWordsInString {

    public String reverseWords(String s) {
        String rev = new StringBuffer(s).reverse().toString();
        String[] words = rev.split(" ");

        int n = words.length;
        int mid = n/2;

        for (int i = 0; i < mid; i++) {
            String tmp = words[i];
            words[i] = words[n-i-1];
            words[n-i-1] = tmp;
        }

        String res = "";
        for (String word : words) {
            res += (" " + word);
        }
        return res.trim();
    }

    public static void main(String[] args) {
        String str = "eat the cereal joe";
        ReverseWordsInString rw = new ReverseWordsInString();
        String rev = rw.reverseWords(str);
        System.out.println(rev);
    }

}
