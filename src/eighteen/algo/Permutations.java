package eighteen.algo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        for (int n : nums) {
            Set<Integer> visited = new HashSet<>();
            List<Integer> permutation = new ArrayList<>();
            permutation.add(n);
            visited.add(n);
            getPermutations(visited, permutation, nums, permutations);
        }
        return permutations;
    }

    private void getPermutations(Set<Integer> visited, List<Integer> permutation, int[] nums, List<List<Integer>> permutations) {

    }
}
