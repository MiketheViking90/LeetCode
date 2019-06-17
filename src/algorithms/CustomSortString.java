package algorithms;

import java.util.*;

public class CustomSortString {
    public String customSortString(String S, String T) {
        Map<Character, Integer> tCounts = new HashMap<>();
        for (char c : T.toCharArray()) {
            int cnt = tCounts.getOrDefault(c, 0);
            tCounts.put(c, cnt+1);
        }

        StringBuilder sb = new StringBuilder();
        for (char c : S.toCharArray()) {
            if (tCounts.containsKey(c)) {
                int cnt = tCounts.get(c);
                for (int i = 0; i < cnt; i++) {
                    sb.append(c);
                }
            }
        }

        Set<Character> sChars = new HashSet<>();
        for (char c : S.toCharArray()) {
            sChars.add(c);
        }
        for (Map.Entry<Character, Integer> entry : tCounts.entrySet()) {
            char c = entry.getKey();
            if (!sChars.contains(c)) {
                for (int i = 0; i < entry.getValue(); i++) {
                    sb.append(c);
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String a = "cba";
        String b = "aabcabacacbdfefefabacacs";

        CustomSortString css = new CustomSortString();
        String sorted = css.customSortString(a, b);
        System.out.println(sorted);
    }
}
