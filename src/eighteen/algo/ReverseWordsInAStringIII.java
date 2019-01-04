package eighteen.algo;

public class ReverseWordsInAStringIII {
    public String reverseWords(String s) {
        int n = s.length();
        int m = n/2;

        char[] sCharAry = s.toCharArray();
        for (int i = 0; i < m; i++) {
            int j = n - i - 1;
            char t = sCharAry[i];
            sCharAry[i] = s.charAt(j);
            sCharAry[j] = t;
        }

        String sRev = new String(sCharAry);
        String[] words = sRev.split(" ");
        n = words.length;
        m = n/2;
        for (int i = 0; i < m; i++) {
            int j = n - i - 1;
            String t = words[i];
            words[i] = words[j];
            words[j] = t;
        }

        String res = "";
        for (String word : words) {
            res += (word + " ");
        }
        return res.substring(0, res.length()-1);
    }
}
