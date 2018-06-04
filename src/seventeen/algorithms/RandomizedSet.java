package seventeen.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RandomizedSet {

    public List<Integer> orderedNums;
    public Map<Integer, Integer> numToIndex;

    public RandomizedSet() {
        orderedNums = new ArrayList<>();
        numToIndex = new HashMap<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        boolean contains = numToIndex.keySet().contains(val);
        if (contains) {
            return false;
        } else {
            int size = orderedNums.size();
            orderedNums.add(val);
            numToIndex.put(val, size);
            return true;
        }
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        boolean contains = numToIndex.keySet().contains(val);
        if (!contains) {
            return false;
        } else {
            int size = orderedNums.size();
            int index = numToIndex.get(val);

            if (index != size-1) {
                int curLast = orderedNums.get(size -  1);
                orderedNums.set(index, curLast);
                numToIndex.put(curLast, index);
            }
            orderedNums.remove(size-1);
            return true;
        }
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int size = orderedNums.size();
        int randIndex = (int) Math.random() * size;
        return orderedNums.get(randIndex);
    }

}
