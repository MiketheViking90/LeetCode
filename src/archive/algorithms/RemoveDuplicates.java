package archive.algorithms;

import java.util.Arrays;

public class RemoveDuplicates {

    int[] removeDuplicates(int[] nums) {
        int n = nums.length;
        int[] uniques = new int[n];
        int uniqueNum = nums[0];
        int j = 1;
        uniques[0] = uniqueNum;

        for (int i = 1; i < n; i++) {
            int num = nums[i];
            if (num != uniqueNum) {
                uniques[j++] = num;
                uniqueNum = num;
            }
        }
        return uniques;
    }

    public static void main(String[] args) {
        int[] val = new int[]{1,1,1,2,2,3,3,3,3,11};
        RemoveDuplicates rm = new RemoveDuplicates();
        int[] unique = rm.removeDuplicates(val);
        System.out.println(Arrays.toString(unique));
    }
}
