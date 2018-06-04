package seventeen.algorithms;

import java.util.ArrayList;
import java.util.List;

public class ComboSums {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> sums = new ArrayList<>();
        findSums(sums, new ArrayList<>(), candidates, 0, 0, target);

        return sums;
    }

    private void findSums(List<List<Integer>> sums, List<Integer> ints, int[] candidates, int i, int sum, int target) {
        if (i == candidates.length) {
            return;
        }

        if (sum > target) {
            return;
        }

        findSums(sums, ints, candidates, i+1, sum, target);

        List<Integer> intsInclude = new ArrayList<>(ints);
        int curNum = candidates[i];
        sum += curNum;
        intsInclude.add(curNum);

        if (sum == target) {
            System.out.println(sum + ": " + intsInclude);
            sums.add(intsInclude);
        } else if (sum < target) {
            findSums(sums, intsInclude, candidates, i + 1, sum, target);
        }
    }

    public static void main(String[] args) {
        ComboSums cs = new ComboSums();
        int[] nums = {10, 1, 2, 7, 6, 1, 5};
        List<List<Integer>> sums = cs.combinationSum2(nums, 8);
        System.out.println(sums);
    }
}
