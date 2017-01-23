package algorithms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindMissingNumbers {

    static List<Integer> findNumbers(int[] nums) {
        Set<Integer> values = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            values.add(i);
        }
        for (int n : nums) {
            values.remove(n);
        }
        return new ArrayList<>(values);
    }

    public static void main(String[] args) {
        Set<Integer> test = new HashSet<>();
        test.remove(123);
    }
}
