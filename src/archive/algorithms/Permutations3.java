package archive.algorithms;

import java.util.ArrayList;
import java.util.List;

public class Permutations3 {

    public List<List<Integer>> permute(int[] strs) {
        List<List<Integer>> perms = new ArrayList<>();
        boolean[] used = new boolean[strs.length];
        getPerms(perms, new ArrayList<>(), used, strs);
        return perms;
    }

    private void getPerms(List<List<Integer>> perms, List<Integer> curPerm, boolean[] used, int[] strs) {
        if (curPerm.size() == strs.length) {
            List<Integer> newPerm = new ArrayList<>(curPerm);
            perms.add(newPerm);
            return;
        }

        for (int i = 0; i < strs.length; i++) {
            if (used[i]) {
                continue;
            }

            curPerm.add(strs[i]);
            used[i] = true;
            getPerms(perms, curPerm, used, strs);
            used[i] = false;
            curPerm.remove(curPerm.size()-1);
        }
    }

    public static void main(String[] args) {
        Permutations3 perm = new Permutations3();
        int[] strings = {1,2,3,4};
        System.out.println(perm.permute(strings));
    }
}
