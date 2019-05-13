package eighteen.algo;

import java.util.HashMap;
import java.util.Map;

public class PalindromePermutation {
    public boolean canPermutePalindrome(String s) {
        Map<Character, Integer> charCounts = new HashMap<>();
        for (char c : s.toCharArray()) {
            int cnt = charCounts.getOrDefault(c, 0);
            charCounts.put(c, cnt+1);
        }

        int oddCount = 0;
        int evenCount = 0;

        for (Map.Entry<Character, Integer> e : charCounts.entrySet()) {
            int cnt = e.getValue();
            if (cnt % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }

        return oddCount <= 1;
    }

    public static void main(String[] args) {
        PalindromePermutation pp = new PalindromePermutation();
        boolean b = pp.canPermutePalindrome("racecar");
        System.out.println(b);
    }
}
