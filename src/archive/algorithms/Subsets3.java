package archive.algorithms;

import java.util.ArrayList;
import java.util.List;

public class Subsets3 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        getSubsets(subsets, new ArrayList<>(), 0, nums);
        return subsets;
    }

    private void getSubsets(List<List<Integer>> subsets, List<Integer> subset, int i, int[] nums) {
        if (i == nums.length) {
            List<Integer> newSubset = new ArrayList<>(subset);
            subsets.add(newSubset);
            return;
        }

        getSubsets(subsets, subset, i+1, nums);
        subset.add(nums[i]);
        getSubsets(subsets, subset, i+1, nums);
        subset.remove(subset.size() - 1);
    }

    public static void main(String[] args) {
        Subsets3 sub = new Subsets3();
        int[] nums = {1,2,3};
        System.out.println(sub.subsets(nums));

    }
}
