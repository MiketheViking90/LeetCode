package algorithms;

import java.util.ArrayList;
import java.util.List;

public class LetterCombsOfAPhoneNumber {
    List<String> letters = getLetters();

    public List<String> letterCombiations(String number) {
        List<String> combos = new ArrayList<>();
        getCombos(number, 0, "", combos);
        return combos;
    }

    private void getCombos(String number, int i, String curCombo, List<String> combos) {
        if (i == number.length()) {
            combos.add(curCombo);
            return;
        }

        int n = number.charAt(i) - '0';
        String nextLetters = letters.get(n);
        for (char c : nextLetters.toCharArray()) {
            getCombos(number, i+1, curCombo+c, combos);
        }
    }

    private List<String> getLetters() {
        List<String> letters = new ArrayList<>();
        letters.add("");
        letters.add("abc");
        letters.add("def");
        letters.add("ghi");
        letters.add("jkl");
        letters.add("mno");
        letters.add("pqrs");
        letters.add("tuv");
        letters.add("wxyz");
        return letters;
    }

    public static void main(String[] args) {
        LetterCombsOfAPhoneNumber lc = new LetterCombsOfAPhoneNumber();
        List<String> combos = lc.letterCombiations("32");
        System.out.println(combos);
    }
}
