package algorithms;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> charCounts = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            int count = charCounts.getOrDefault(c, 0);
            charCounts.put(c, count+1);
        }

        for (char c : ransomNote.toCharArray()) {
            if (!charCounts.containsKey(c)) {
                return false;
            }
            int n = charCounts.get(c);
            if (n <= 0) {
                return false;
            }
            charCounts.put(c, n-1);
        }
        return true;
    }
}
