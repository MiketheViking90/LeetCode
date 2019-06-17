package algorithms;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> keyToAnagrams = new HashMap<>();
        for (String str : strs) {
            char[] sortedChars = str.toCharArray();
            Arrays.sort(sortedChars);
            String key = String.valueOf(sortedChars);

            List<String> grams = keyToAnagrams.getOrDefault(key, new ArrayList<>());
            grams.add(str);
            keyToAnagrams.put(key, grams);
        }

        List<List<String>> anagrams = new ArrayList<>();
        for (List<String> gram : keyToAnagrams.values()) {
            anagrams.add(gram);
        }
        return anagrams;
    }
}
