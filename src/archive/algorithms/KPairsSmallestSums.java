package archive.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KPairsSmallestSums {

    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> pairs = new ArrayList<>();
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return pairs;
        }

        int i = 0;
        int j = 0;

        int n1 = nums1.length;
        int n2 = nums2.length;

        while (k > 0) {
            int x = nums1[i];
            int y = nums2[j];
            int[] pair = new int[]{x, y};
            pairs.add(pair);
            System.out.println(Arrays.toString(pair));
            if (i == n1-1 && j == n2-1) {
                return pairs;
            }
            if (i == n1 -1 || y > x) {
                j++;
            } else if (j == n2 -1 || x >= y) {
                i++;
            }

            k--;
        }

        return pairs;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,7,11};
        int[] nums2 = {2,4,6};
        int k = 3;

        KPairsSmallestSums kp = new KPairsSmallestSums();
        kp.kSmallestPairs(nums1, nums2, 3);
    }
}
