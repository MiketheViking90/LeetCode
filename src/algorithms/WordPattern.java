package algorithms;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        Map<Character, String> patternToWord = new HashMap<>();
        Map<String, Character> wordToPattern = new HashMap<>();

        int N = pattern.length();

        String[] words = str.split(" ");
        for (int i = 0; i < N; i++) {
            char pat = pattern.charAt(i);
            String word = words[i];

            String curWord = patternToWord.get(pat);
            Character curPat = wordToPattern.get(word);

            if (curWord != null && !curWord.equals(word)) {
                return false;
            }
            if (curPat!= null && !curPat.equals(pat)) {
                return false;
            }
            wordToPattern.put(word, pat);
            patternToWord.put(pat, word);
        }
        return true;
    }
}
