package eighteen.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {

    private static Map<Integer, List<Character>> digitToChars = new HashMap<>();
    static {
        digitToChars.put(2, Arrays.asList('a', 'b', 'c'));
        digitToChars.put(3, Arrays.asList('d', 'e', 'f'));
        digitToChars.put(4, Arrays.asList('g', 'h', 'i'));
        digitToChars.put(5, Arrays.asList('j', 'k', 'l'));
        digitToChars.put(6, Arrays.asList('m', 'n', 'o'));
        digitToChars.put(7, Arrays.asList('p', 'q', 'r', 's'));
        digitToChars.put(8, Arrays.asList('t', 'u', 'v'));
        digitToChars.put(9, Arrays.asList('w', 'x', 'y', 'z'));
    }

    List<String> letterCombinations(String digits) {
        List<String> combos = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return combos;
        }

        genCombos(combos, "", digits, 0);
        return combos;
    }

    private void genCombos(List<String> combos, String combo, String digits, int idx) {
        if (idx == digits.length()) {
            combos.add(combo);
            return;
        }

        char digitChar = digits.charAt(idx);
        int digit = digitChar - '0';
        List<Character> chars = digitToChars.get(digit);

        for (char c : chars) {
            genCombos(combos, combo + c, digits, idx+1);
        }
    }

    public static void main(String[] args) {
        LetterCombinationsOfAPhoneNumber lc = new LetterCombinationsOfAPhoneNumber();
        List<String> combos = lc.letterCombinations("23434");
        System.out.println(combos);
    }

}
