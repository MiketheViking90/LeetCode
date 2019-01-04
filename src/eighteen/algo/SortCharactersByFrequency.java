package eighteen.algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SortCharactersByFrequency {

    public String frequencySort(String s) {
        Map<Character, Integer> charToCount = new HashMap<>();
        for (char c : s.toCharArray()) {
            charToCount.put(c, charToCount.getOrDefault(c, 0)+1);
        }

        Map<Integer, List<Character>> countToChar = new TreeMap<>();
        for (Map.Entry<Character, Integer> e : charToCount.entrySet()) {
            char c = e.getKey();
            int v = e.getValue();
            List<Character> chars = countToChar.getOrDefault(v, new ArrayList<>());
            chars.add(c);
            countToChar.put(v, chars);
        }

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer, List<Character>> e : countToChar.entrySet()) {
            int n = e.getKey();
            List<Character> chars = e.getValue();

            for (char c : chars) {
                for (int i = 0; i < n; i++) {
                    sb.append(c);
                }
            }
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        SortCharactersByFrequency sb = new SortCharactersByFrequency();
        String sorted = sb.frequencySort("tree");
        System.out.println(sorted);
    }
}
