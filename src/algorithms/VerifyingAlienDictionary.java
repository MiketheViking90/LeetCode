package algorithms;

import java.util.HashMap;
import java.util.Map;

public class VerifyingAlienDictionary {
    public boolean isAlienSorted(String[] words, String order) {
        int N = words.length;
        Map<Character, Integer> charToIdx = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            char c = order.charAt(i);
            charToIdx.put(c, i);
        }


        for (int i = 0; i <= N-2; i++) {
            String w1 = words[i];
            String w2 = words[i+1];

            if (!inOrder(w1, w2, charToIdx)) {
                return false;
            }
        }
        return true;
    }

    private boolean inOrder(String w1, String w2, Map<Character, Integer> order) {
        int m = w1.length();
        int n = w2.length();

        int i = 0;
        int j = 0;
        while (i < m && j < n) {
            char c1 = w1.charAt(i);
            char c2 = w2.charAt(j);

            if (c1 == c2) {
                i++;
                j++;
            } else {
                return order.get(c1) < order.get(c2);
            }
        }
        return i < j;
    }

    public static void main(String[] args) {
        VerifyingAlienDictionary vad = new VerifyingAlienDictionary();
        String[] words = {"apple", "app"};
        String order = "worldabcefghijkmnpqstuvxyz";
        boolean b = vad.isAlienSorted(words, order);
        System.out.println(b);
    }
}
