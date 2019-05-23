package eighteen.algo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        Set<Integer> remainder = new HashSet<>();
        for (int n : nums) {
            remainder.add(n);
        }
        getPermutations(new ArrayList<>(), remainder, permutations);
        return permutations;
    }

    private void getPermutations(List<Integer> perm, Set<Integer> remain, List<List<Integer>> permutations) {
        if (remain.isEmpty()) {
            permutations.add(perm);
            return;
        }

        for (int n : remain) {
           List<Integer> nextPerm = new ArrayList<>(perm);
           Set<Integer> nextRemain = new HashSet<>(remain);

           nextPerm.add(n);
           nextRemain.remove(n);
           getPermutations(nextPerm, nextRemain, permutations);
        }
    }

    public static void main(String[] args) {
        Permutations perms = new Permutations();
        int[] nums = {1,3,2};
        List<List<Integer>> ps = perms.permute(nums);
        System.out.println(ps);
    }
}
