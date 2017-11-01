package algorithms;

import java.util.ArrayList;
import java.util.List;

public class Subsets2 {

    public List<List<Integer>> getSubsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        findSubsets(subsets, 0, new ArrayList<>(), nums);
        return subsets;
    }

    private void findSubsets(List<List<Integer>> subsets, int idx, List<Integer> cur, int[] nums) {
        int len = nums.length;
        if (idx == len) {
            subsets.add(new ArrayList<>(cur));
            return;
        }

        findSubsets(subsets, idx+1, cur, nums);

        int n = nums[idx];
        cur.add(n);
        findSubsets(subsets, idx+1, cur, nums);
        cur.remove(cur.size()-1);
    }

    public static void main(String[] args) {
        Subsets2 ss = new Subsets2();
        int[] nums = {1, 2, 3};
        List<List<Integer>> subsets = ss.getSubsets(nums);
        System.out.println(subsets);
    }
}
