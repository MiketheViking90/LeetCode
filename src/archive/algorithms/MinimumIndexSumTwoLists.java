package archive.algorithms;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MinimumIndexSumTwoLists {

    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> nameToIndex = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            String name = list1[i];
            nameToIndex.put(name, i);
        }

        int minSum = Integer.MAX_VALUE;
        for (int i = 0; i < list2.length; i++) {
            String name = list2[i];
            if (nameToIndex.keySet().contains(name)) {
                int curSum = i + nameToIndex.get(name);

                if (minSum > curSum) {
                    minSum = curSum;
                }
            }
        }

        Set<String> minNames = new HashSet<>();
        for (int i = 0; i < list2.length; i++) {
            String name = list2[i];
            if (nameToIndex.keySet().contains(name)) {
                int curSum = i + nameToIndex.get(name);

                if (curSum == minSum) {
                    minNames.add(name);
                }
            }
        }

        return minNames.toArray(new String[0]);
    }
}
