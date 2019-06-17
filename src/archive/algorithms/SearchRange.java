package archive.algorithms;

import java.util.Arrays;

public class SearchRange {

    public int[] searchRange(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;

        while (lo <= hi) {
            int med = (hi + lo) / 2;
            int medVal = nums[med];

            if (medVal == target) {
                return getRangeBound(nums, med);
            } else if (medVal > target) {
                hi = med - 1;
            } else {
                lo = med + 1;
            }
        }

        return new int[]{-1, -1};
    }

    private int[] getRangeBound(int[] nums, int med) {
        int val = nums[med];
        int i = med;
        while (i >= 0 && nums[i] == val) {
            i--;
        }


        int j = med;
        while (j < nums.length && nums[j] == val) {
            j++;
        }

        return new int[]{i, j};
    }

    public static void main(String[] args) {
        int[] nums = {8,8,8,8,10};
        SearchRange sr = new SearchRange();
        int[] endpts = sr.searchRange(nums, 8);
        System.out.println(Arrays.toString(endpts));
    }

}
