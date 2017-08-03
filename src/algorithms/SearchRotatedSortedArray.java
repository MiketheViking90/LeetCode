package algorithms;

public class SearchRotatedSortedArray {

    int search(int[] nums, int target) {
        int n = nums.length - 1;
        int lowIndex = getLowIndex(nums, 0, n);

        int lastNumber = nums[n];
        if (target == lastNumber) {
            return n;
        } else if (target == nums[0]) {
            return 0;
        } else if (target == nums[lowIndex]) {
            return lowIndex;
        }

        if (target < lastNumber) {
            return binSearch(nums, lowIndex + 1, lastNumber - 1, target);
        } else {
            return binSearch(nums, 1, lowIndex - 1, target);
        }

    }

    private int binSearch(int[] nums, int lo, int hi, int target) {
        while (lo < hi) {
            int mid = (hi+lo) / 2;
            int midVal = nums[mid];

            if (midVal == target) {
                return mid;
            } else if (midVal > target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return -1;
    }

    private int getLowIndex(int[] nums, int lo, int hi) {
        if (lo >= hi) {
            return 0;
        }

        int mid = (hi + lo) / 2;
        if (nums[mid] > nums[mid+1]) {
            return mid;
        }

        return Math.max(
            getLowIndex(nums, lo+1, hi),
            getLowIndex(nums, lo, hi - 1)
        );
    }

}
