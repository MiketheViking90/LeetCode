public class MajorityElement {

    public int majorityElement(int[] nums) {
        int major = nums[0];
        int cnt = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == major) {
                cnt++;
            } else {
                cnt--;

                if (cnt == 0) {
                    major = nums[i];
                    cnt = 1;
                }
            }
        }
        return major;
    }
}
