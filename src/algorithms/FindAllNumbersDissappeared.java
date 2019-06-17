package algorithms;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDissappeared {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int N = nums.length;
        for (int i = 0; i < N; i++) {
            int n = Math.abs(nums[i]);
            if (nums[n-1] > 0) {
                nums[n-1] *= -1;
            }
        }
        List<Integer> missingNo = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if (nums[i] > 0) {
                missingNo.add(i+1);
            }
        }
        return missingNo;
    }

    public static void main(String[] args) {
        FindAllNumbersDissappeared fl = new FindAllNumbersDissappeared();
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println(fl.findDisappearedNumbers(nums));
    }
}
