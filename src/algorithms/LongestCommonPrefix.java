package algorithms;

public class LongestCommonPrefix {

    String longestCommonPrefix(String[] strs) {
        int max = 0;

        int i = 0;
        String word = strs[0];
        while (i < word.length()) {
            char c = word.charAt(i);

            for (String str : strs) {
                if (str.length() <= i || str.charAt(i) != c) {
                    return strs[0].substring(0, max);
                }
            }
            max++;
            i++;
        }
        return strs[0].substring(0, max);
    }

    public static void main(String[] args) {
        String[] strs = {"flower","fl","flight"};

        LongestCommonPrefix lcp = new LongestCommonPrefix();
        String pre = lcp.longestCommonPrefix(strs);
        System.out.println(pre);
    }
}
