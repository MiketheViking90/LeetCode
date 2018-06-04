package seventeen.algorithms;

import java.util.*;

public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        Set<Integer> remainder = new HashSet<>();
        for (int n : nums) {
            remainder.add(n);
        }

        int n = nums.length;
        generatePermutations(0, remainder, new int[n], permutations);
        return permutations;
    }

    private void generatePermutations(int i, Set<Integer> remainder, int[] perm, List<List<Integer>> permutations) {
        if (remainder.size() == 0) {
            System.out.println(Arrays.toString(perm));

            List<Integer> permAsList = new ArrayList<>();
            for (int n : perm) {
                permAsList.add(n);
            }
            permutations.add(permAsList);
            return;
        }

        for (int n : remainder) {
            perm[i] = n;
            Set<Integer> nowRemains = new HashSet<>(remainder);
            nowRemains.remove(n);
            generatePermutations(i++, nowRemains, perm, permutations);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        Permutations perm = new Permutations();
        List<List<Integer>> perms = perm.permute(nums);

        for (List<Integer> p : perms) {
            //System.out.println(p);
        }
    }
}
