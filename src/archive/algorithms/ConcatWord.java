package archive.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ConcatWord {

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> concats = new ArrayList<>();
        List<String> wordList = Arrays.asList(words);
        wordList.sort(Comparator.comparingInt(String::length));

        System.out.println(wordList);
        int n = words.length;
        for (int i = 1; i < n; i++) {
            if (wordBreak(i, wordList)) {
                concats.add(wordList.get(i));
            }
        }

        return concats;
    }

    private boolean wordBreak(int index, List<String> dict) {
        String word = dict.get(index);
        int n = word.length();
        boolean[] M = new boolean[n+1];

        M[0] = true;

        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j <= n; j++) {
                String subStr = word.substring(i, j);
                System.out.println(subStr);
                if (M[i] && dict.contains(subStr) && (dict.indexOf(subStr) < index)) {
                    System.out.println("\tfound");
                    M[j] = true;
                    break;
                }
            }
        }

        return M[n];
    }

    public static void main(String[] args) {
        ConcatWord cw = new ConcatWord();

        String[] dict = {"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"};
        List<String> concats = cw.findAllConcatenatedWordsInADict(dict);
        System.out.println(concats);
    }
}
