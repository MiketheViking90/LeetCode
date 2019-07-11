package algorithms;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class LonelyIsland {
    Map<Integer, Integer> islandToIn = new HashMap<>();
    Map<Integer, Integer> islandToOut = new HashMap<>();

    public Integer findLonelyIslands(List<List<Integer>> bridges) {
        for (List<Integer> bridge : bridges) {
            int source = bridge.get(0);
            int dest = bridge.get(1);

            islandToOut.put(source, islandToOut.getOrDefault(source, 0) + 1);
            islandToIn.put(dest, islandToOut.getOrDefault(dest, 0) + 1);
        }

        Set<Integer> noExits = islandToOut.entrySet().stream().filter(e -> e.getValue() == 0).map(e -> e.getKey()).collect(Collectors.toSet());

        int maxEntry = 0;
        int maxEntryValue = -1;
        for (int n : noExits) {
            if (islandToIn.get(n) > maxEntry) {
                maxEntry = islandToIn.get(n);
                maxEntryValue = n;
            }
        }
        return maxEntryValue;
    }
}
