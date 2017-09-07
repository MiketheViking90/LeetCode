package TwoSigma;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class StringChains {
    static int longestChain(String[] words) {
        if (words == null || words.length == 0) {
            return 0;
        }

        Comparator<String> lengthComp = Comparator.comparing(String::length);
        Arrays.sort(words, lengthComp);

        int longest = 0;
        Map<String, Integer> wordToChain = new HashMap<>();
        for (String word : words) {
            wordToChain.put(word, 1);
            for (int i = 0; i < word.length(); i++) {
                StringBuilder curWord = new StringBuilder(word);
                String nextWord = curWord.deleteCharAt(i).toString();

                if (wordToChain.containsKey(nextWord)) {
                    int nextWordChain = wordToChain.get(nextWord) + 1;
                    if (nextWordChain > wordToChain.get(word)) {
                        wordToChain.put(word, nextWordChain);
                    }
                }
            }
            longest = Math.max(longest, wordToChain.get(word));
        }
        return longest;
    }

    public static void main(String[] args) {
        String[] words = {"a", "b", "ba", "bca", "bda", "bdca"};
    }
}
