package archive.algorithms;

import java.util.ArrayList;
import java.util.List;

public class ComboSum {

    List<List<Integer>> combos = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        findCombos(candidates, target, 0, "", combos);
        return combos;
    }

    private void findCombos(int[] nums, int sum, int i, String combo, List<List<Integer>> combos) {
        if (i == nums.length) {
            return;
        }

        int val = nums[i];

        if (val > sum) {
            findCombos(nums, sum, i+1, combo, combos);
        } else if (sum == val) {
            System.out.println(combo + ", " + val);
            return;
        }
        findCombos(nums, sum - val, i+1, combo + ", " + val, combos);
        findCombos(nums, sum, i+1, combo, combos);
    }

    public static void main(String[] args) {
        ComboSum sum = new ComboSum();

        int[] nums = {2, 5, 2, 1, 6, 5, 7};
        int n = 7;
        sum.combinationSum(nums, n);
    }
}
