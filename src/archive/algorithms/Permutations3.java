package archive.algorithms;

import java.util.ArrayList;
import java.util.List;

public class Permutations3 {

    public List<List<String>> permute(String[] strs) {
        List<List<String>> perms = new ArrayList<>();
        getPerms(new ArrayList<>(), perms, 0, strs);
        return perms;
    }

    private void getPerms(List<String> curPerm, List<List<String>> perms, int i, String[] strs) {
        if (i == strs.length) {
            List<String> newPerm = new ArrayList<>(curPerm);
            return;
        }

        List<String> nextPerm = new ArrayList<>(curPerm);

        for (int j = i; j < strs.length; j++) {
            String str = strs[j];
            curPerm.add(str);
            getPerms(curPerm, perms, i+1, strs);
            curPerm.remove(curPerm.size()-1);
        }
    }

    public static void main(String[] args) {
        Permutations3 perm = new Permutations3();
        String[] strings = {"a", "b", "c", "d"};
        perm.permute(strings);
    }
}
