package seventeen.algorithms;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public List<String> subsets(int[] nums) {
        List<String> powerset = new ArrayList<>();
        generatePowerset(nums, 0, "", powerset);

        return powerset;
    }

    private void generatePowerset(int[] nums, int i, String curSet, List<String> powerset) {
        if (i == nums.length) {
            powerset.add(curSet);
            return;
        }

        generatePowerset(nums, i+1, curSet + nums[i], powerset);
        generatePowerset(nums, i+1, curSet, powerset);
    }

    public static void main(String[] args) {
        Subsets ss = new Subsets();

        int[] nums = {1, 2, 3, 4, 5, 6};
        List<String> powerset = ss.subsets(nums);
        System.out.println(powerset);
    }

}
