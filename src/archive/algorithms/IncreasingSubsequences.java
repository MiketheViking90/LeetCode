package archive.algorithms;

import java.util.ArrayList;
import java.util.List;

public class IncreasingSubsequences {

    public List<String> findSubsequences(int[] nums) {
        List<String> seqs = new ArrayList<>();
        findSubsequences(nums, 0, seqs, "");
        return seqs;
    }

    private void findSubsequences(int[] nums, int i, List<String> seqs, String curSeq) {
        if (curSeq.length() >= 2) {
            seqs.add(curSeq);
        }

        if (i >= nums.length) {
            return;
        }

        findSubsequences(nums, i+1, seqs, curSeq);

        int nextNum = nums[i];
        if (curSeq.length() == 0) {
            findSubsequences(nums, i+1, seqs, curSeq + nextNum);
        } else {
            int curNum = (curSeq.charAt(curSeq.length()-1) - '0');
            if (curNum < nextNum) {
                findSubsequences(nums, i + 1, seqs, curSeq + nextNum);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {4, 6, 2, 7};
        IncreasingSubsequences is = new IncreasingSubsequences();
        List<String> seqs = is.findSubsequences(nums);
        System.out.println(seqs);
    }
}
