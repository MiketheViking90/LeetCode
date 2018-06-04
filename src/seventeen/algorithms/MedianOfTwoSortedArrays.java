package seventeen.algorithms;

public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        int len = l1 + l2;
        int medIndex = len / 2;

        int i = 0;
        int j = 0;
        while (medIndex > 1) {
            if (i == l1-1) {
                j++;
            } else if (j == l2-1) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                i++;
            }
            medIndex--;
        }

        if (len % 2 == 0) {
            return ((nums1[i] + nums2[j]) /  2.0);
        } else {
            return Math.max(nums1[i], nums2[j]);
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {3, 4};

        MedianOfTwoSortedArrays mtsa = new MedianOfTwoSortedArrays();
        System.out.println(mtsa.findMedianSortedArrays(nums1, nums2));
    }

}
