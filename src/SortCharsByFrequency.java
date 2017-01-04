import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortCharsByFrequency {

    public String frequencySort(String s) {
        Map<Character, Long> charToCountMap = countCharsInString(s);
        Map<Long, List<Character>> countToCharMap = indexCharsByCount(charToCountMap);

        StringBuilder sorted = new StringBuilder();
        for (long i : countToCharMap.keySet()) {
            List<Character> chars = countToCharMap.get(i);
            for (char c : chars) {
                for (int j = 0; j < i; j++) {
                    sorted.insert(0, c);
                }
            }
        }

        return sorted.toString();
    }

    private Map<Long,List<Character>> indexCharsByCount(Map<Character, Long> charToCountMap) {
        Map<Long, List<Character>> countToCharMap = new HashMap<>();

        for (char c : charToCountMap.keySet()) {
            long count = charToCountMap.get(c);

            if (countToCharMap.containsKey(count)) {
                List<Character> val = countToCharMap.get(count);
                val.add(c);
            } else {
                List<Character> val = new ArrayList<>();
                val.add(c);
                countToCharMap.put(count, val);
            }
        }

        return countToCharMap;
    }

    private Map<Character, Long> countCharsInString(String s) {
        Map<Character, Long> charToCountMap = new HashMap<>();

        for (char c : s.toCharArray()) {
            if (charToCountMap.containsKey(c)) {
                long value = charToCountMap.get(c);
                charToCountMap.put(c, ++value);
            } else {
                charToCountMap.put(c, 1L);
            }
        }
        return charToCountMap;
    }

    public static void main(String[] args) {
        SortCharsByFrequency sort = new SortCharsByFrequency();
        String s = "tree";
        String res = sort.frequencySort(s);
        System.out.println(res);
    }

}
