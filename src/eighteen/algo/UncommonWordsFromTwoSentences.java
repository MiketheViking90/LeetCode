package eighteen.algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class UncommonWordsFromTwoSentences {
    public String[] uncommonFromSentences(String A, String B) {
        Set<String> aWords = getUniqueWords(A);
        Set<String> bWords = getUniqueWords(B);

        List<String> uniques = new ArrayList<>();

        for (String word : aWords) {
            if (!bWords.contains(aWords)) {
                uniques.add(word);
            }
        }

        for (String word : bWords) {
            if (!aWords.contains(aWords)) {
                uniques.add(word);
            }
        }

        return uniques.toArray(new String[uniques.size()]);
    }

    private Set<String> getUniqueWords(String A) {
        String[] aList = A.split(" ");
        Map<String, Integer> aWords = new HashMap<>();

        for (String word : aList) {
            int n = aWords.getOrDefault(word, 0);
            aWords.put(word, n+1);
        }

        return aWords.entrySet()
                .stream()
                .filter(e -> e.getValue() == 1)
                .map(e -> e.getKey())
                .collect(Collectors.toSet());
    }
}
