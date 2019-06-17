package algorithms;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        getSubsets(new ArrayList<>(), subsets, 0, nums);
        return subsets;
    }

    private void getSubsets(List<Integer> set, List<List<Integer>> subsets, int i, int[] nums) {
        if (i == nums.length) {
            List<Integer> newSet = new ArrayList<>(set);
            subsets.add(set);
            return;
        }
        getSubsets(set, subsets, i+1, nums);
        List<Integer> newSet2 = new ArrayList<>(set);
        newSet2.add(nums[i]);
        getSubsets(newSet2, subsets, i+1, nums);
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 3, 4, 5};
        Subsets ss = new Subsets();
        System.out.println(ss.subsets(nums));
    }
}
