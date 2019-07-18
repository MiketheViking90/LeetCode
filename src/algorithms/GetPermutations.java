package algorithms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GetPermutations {
    public List<List<Integer>> getPermutations(int[] nums) {
        List<List<Integer>> perms = new ArrayList<>();
        permute(new ArrayList<>(), perms, new HashSet<>(), nums);
        return perms;
    }

    private void permute(List<Integer> perm, List<List<Integer>> perms, Set<Integer> visited, int[] nums) {
        int N = nums.length;
        if (perm.size() == N) {
            List<Integer> permCopy = new ArrayList<>(perm);
            perms.add(permCopy);
            return;
        }
        for (int num : nums) {
            if (!visited.contains(num)) {
                visited.add(num);
                perm.add(num);
                permute(perm, perms, visited, nums);
                perm.remove(perm.size()-1);
                visited.remove(num);
            }
        }
    }

    public static void main(String[] args) {
        GetPermutations gp = new GetPermutations();
        int[] nums = {1,2,3,4};
        System.out.println(gp.getPermutations(nums));
    }
}
