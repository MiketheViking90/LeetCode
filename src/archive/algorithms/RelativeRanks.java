package archive.algorithms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class RelativeRanks {

    public String[] findRelativeRanks(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(3);
        for (int n : nums) {
            pq.add(n);
        }

        Map<Integer, String> valToMedal = new HashMap<>();
        String[] medals = {"Gold Medal", "Silver Medal", "Bronze Medal"};
        for (int i = 0; i < 3; i++) {
            int val = pq.poll();
            valToMedal.put(val, medals[i]);
        }

        String[] ranks = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            String rank = valToMedal.getOrDefault(n, String.valueOf(n));
            ranks[i] = rank;
        }

        return ranks;
    }

    public static void main(String[] args) {
        int[] nums = {5, 4, 3, 2, 1};

        RelativeRanks rr = new RelativeRanks();
        String[] ranks = rr.findRelativeRanks(nums);

        System.out.println(Arrays.toString(ranks));
    }
}
