package algorithms;

import java.util.HashSet;
import java.util.Set;

public class AllCombosLessThan {

    public void getAllCombos(Set<Integer> nums, int max) {
        for (int n : nums) {
            getCombos(String.valueOf(n), nums, max);
        }
    }

    private void getCombos(String s, Set<Integer> nums, int max) {
        if (Integer.parseInt(s) >= max) {
            return;
        }

        if (Integer.parseInt(s) < max) {
            System.out.println(s);
        }

        for (int n :nums) {
            getCombos(s + n, nums, max);
        }
    }

    public static void main(String[] args) {
        AllCombosLessThan ac = new AllCombosLessThan();
        Set<Integer> nums = new HashSet<>();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(4);
        ac.getAllCombos(nums, 10000);
    }
}
