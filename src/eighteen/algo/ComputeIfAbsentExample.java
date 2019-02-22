package eighteen.algo;

import java.util.HashMap;
import java.util.Map;

public class ComputeIfAbsentExample {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 3);
        map.put(2, 4);
        map.put(3, 5);

        int[] nums = {3, 1, 4, 5, 6};
        for (int n : nums) {
            map.computeIfAbsent(n, k -> k+1);
        }
        System.out.println(map);
    }
}
