package eighteen.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAndReplacePattern {

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> matches = new ArrayList<>();
        for (String word : words) {
            if (isMatch(word, pattern)) {
                matches.add(word);
            }
        }

        return matches;
    }

    private boolean isMatch(String word, String pattern) {
        if (word.length() != pattern.length()) {
            return false;
        }

        Map<Character, Character> wordToPattern = new HashMap<>();
        Map<Character, Character> patternToWord= new HashMap<>();

        for (int i = 0; i < word.length(); i++) {
            char w1 = word.charAt(i);
            char w2 = pattern.charAt(i);

            if (wordToPattern.containsKey(w1) && patternToWord.containsKey(w2)) {
                char fW1 = wordToPattern.get(w1);
                char fW2 = patternToWord.get(w2);

                if (fW1 != w2 || fW2 != w1) {
                    return false;
                }
            } else if (!wordToPattern.containsKey(w1) && !patternToWord.containsKey(w2)) {
                updateMaps(wordToPattern, patternToWord, w1, w2);
            } else {
                return false;
            }
        }


        return false;
    }

    private void updateMaps(Map<Character, Character> wordToPattern, Map<Character, Character> patternToWord, char w1, char w2) {
        wordToPattern.put(w1, w2);
        patternToWord.put(w2, w1);
    }

    public static void main(String[] args) {
        String w1 = "abcd";
        String w2 = "ueyd";

        FindAndReplacePattern farp = new FindAndReplacePattern();
        List<String> matches = farp.findAndReplacePattern(new String[]{w1}, w2);
        System.out.println(Arrays.toString(matches.toArray()));
    }

}
