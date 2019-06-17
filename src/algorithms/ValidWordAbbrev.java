package algorithms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ValidWordAbbrev {
    public boolean validWordAbbrev(String[] dict) {
        Set<String> words = new HashSet<>(Arrays.asList(dict));
        Set<String> abbrevs = new HashSet<>();
        for (String word : words) {
            String abbrev = getAbbrev(word);
            if (abbrevs.contains(abbrev)) {
                return false;
            }
            abbrevs.add(abbrev);
        }
        return false;
    }

    private String getAbbrev(String word) {
        int N = word.length();
        return word.substring(0,1) + (N-2) + word.substring(N-2, N-1);
    }

    public static void main(String[] args) {
        String[] dict = {"dear", "cart", "cane", "make"};
        ValidWordAbbrev vwa = new ValidWordAbbrev();
        boolean b = vwa.validWordAbbrev(dict);
        System.out.println(b);
    }
}
