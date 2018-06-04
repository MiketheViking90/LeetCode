package seventeen.algorithms;

import lombok.ToString;

import java.util.*;

public class TopKFrequentElements {

    @ToString
    private class ValueAndCount implements Comparable<ValueAndCount> {
        int value;
        int count;

        public ValueAndCount(int v, int c) {
            this.value = v;
            this.count = c;
        }

        @Override
        public int compareTo(ValueAndCount o) {
            if (this.count == o.count) {
                return Integer.compare(this.value, o.value);
            }
            return Integer.compare(o.count, this.count);
        }
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> nToCnt = new HashMap<>();
        for (int n : nums) {
            int cnt = nToCnt.getOrDefault(n, 0);
            nToCnt.put(n, cnt+1);
        }

        PriorityQueue<ValueAndCount> countPQ = new PriorityQueue<>(k);
        for (Map.Entry<Integer, Integer> entry : nToCnt.entrySet()) {
            ValueAndCount vc = new ValueAndCount(entry.getKey(), entry.getValue());
            countPQ.offer(vc);
        }


        List<Integer> vals = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            vals.add(countPQ.poll().value);
        }
        return vals;
    }

    public static void main(String[] args) {
        TopKFrequentElements tk = new TopKFrequentElements();
        int[] nums = {3,1,4,1,1,3,2,1,2,3,5,6,8,3};
        List<Integer> vals = tk.topKFrequent(nums, 3);
        System.out.println(vals);
    }

}
