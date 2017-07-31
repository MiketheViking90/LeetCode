package algorithms;

public class BinarySearch {

    public static int bSearch(int[] nums, int n) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int mid = (r+l)/2;
            int m = nums[mid];
            if (m == n) {
                return mid;
            } else if (m > n) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    public static int bSearchR(int[] nums, int n) {
        return bSearchR(nums, n, 0, nums.length - 1);
    }

    private static int bSearchR(int[] nums, int n, int l, int r) {
        if (l > r) {
            return -1;
        }

        int mid = (r + l) / 2;
        int m = nums[mid];

        if (n == m) {
            return mid;
        } else  if (n > m) {
            return bSearchR(nums, n, mid + 1, r);
        } else {
            return bSearchR(nums, n, l, mid - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,2,2,3,8,12,14};
        int i = bSearch(nums, 5);
        System.out.println(i);
        System.out.println(bSearchR(nums, 14));
    }

}
