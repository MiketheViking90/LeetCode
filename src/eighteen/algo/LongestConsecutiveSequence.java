package eighteen.algo;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numsSet = new HashSet<>();
        for (int n : nums) {
            numsSet.add(n);
        }

        int maxLen = 0;
        for (int n : nums) {
            if (!numsSet.contains(n-1)) {
                int curNum = n;
                int len = 1;

                while (numsSet.contains(curNum+1)) {
                    len++;
                    curNum++;
                }
                maxLen = Math.max(len, maxLen);
            }
        }
        return maxLen;
    }
}
