package seventeen.algorithms;

import java.util.ArrayList;
import java.util.List;

public class Permutations2 {

    public List<String> permute(String str) {
        List<String> perms = new ArrayList<>();
        findPermutations("", str, perms);
        return perms;
    }

    private void findPermutations(String perm, String str, List<String> perms) {
        if (str.length() == 0) {
            System.out.println(perm);
            perms.add(perm);
            return;
        }

        int n = str.length();
        for (int j = 0; j < n; j++) {
            char c = str.charAt(j);
            String pre = str.substring(0, j);
            String suf = str.substring(j+1);

            findPermutations(perm + c, pre+suf, perms);
        }
    }

    public static void main(String[] args) {
        Permutations2 perm = new Permutations2();
        List<String> perms = perm.permute("abcd");
        System.out.println(perms);
    }
}
