package seventeen.algorithms;

import java.util.ArrayList;
import java.util.List;

public class StringPermutations {

    public List<String> getPermutations(String str) {
        List<String> permutations = new ArrayList<>();
        findPermutations("", str, permutations);

        return permutations;
    }

    private void findPermutations(String pre, String suf, List<String> permutations) {
        int n = suf.length();
        if (suf.length() == 0) {
            permutations.add(pre);
            return;
        }

        for (int i = 0; i < n; i++) {
            findPermutations(pre + suf.charAt(i), suf.substring(0, i) + suf.substring(i+1), permutations);
        }
    }

    public static void main(String[] args) {
        StringPermutations sp = new StringPermutations();
        List<String> permutations  = sp.getPermutations("abcd");
        System.out.println(permutations);
    }

}
