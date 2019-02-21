package eighteen.algo;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {
    public List<String> letterCasePermutation(String S) {
        List<String> perms = new ArrayList<>();
        getPerms("", 0, S, perms);
        return perms;
    }

    private void getPerms(String perm, int i, String S, List<String> perms) {
        if (i == S.length()) {
            perms.add(perm);
            return;
        }
        char c = S.charAt(i);

        if (Character.isLetter(c)) {
            getPerms(perm+Character.toLowerCase(c), i+1, S, perms);
            getPerms(perm+Character.toUpperCase(c), i+1, S, perms);
        } else {
            getPerms(perm+c, i+1, S, perms);
        }
    }
}
