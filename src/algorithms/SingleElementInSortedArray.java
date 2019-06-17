package algorithms;

public class SingleElementInSortedArray {
    public int singleNonDuplicate(int[] nums) {
        return binSearch(nums, 0, nums.length-1);
    }

    private int binSearch(int[] nums, int l, int r) {
        if (l > r) {
            return -1;
        }

        int m = (r + l)/2;
        int mv = nums[m];
        if (m == 0) {
            return (mv != nums[1]) ? mv : -1;
        } else if (m == nums.length-1) {
            return mv != nums[nums.length-2] ? mv : -1;
        } else if (mv != nums[m-1] && mv != nums[m+1]) {
            return mv;
        } else {
            int lSearch = binSearch(nums, l, m-1);
            int rSearch = binSearch(nums, m+1, r);
            return Math.max(lSearch, rSearch);
        }
    }

    public static void main(String[] args) {
        SingleElementInSortedArray se = new SingleElementInSortedArray();
        //int[] nums = {1,1,2};
        int[] nums = {3,3,7,7,10,11,11};
        int n = se.singleNonDuplicate(nums);
        System.out.println(n);
    }
}
