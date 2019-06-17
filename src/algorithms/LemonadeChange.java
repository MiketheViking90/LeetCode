package algorithms;

import java.util.HashMap;
import java.util.Map;

public class LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        Map<Integer, Integer> changeCounts = new HashMap<>();
        for (int bill : bills) {
            if (bill == 5) {
                updateMap(changeCounts, 5);
            } else if (bill == 10) {
                if (noChange(changeCounts, 5)) {
                    return false;
                } else {
                    updateMap(changeCounts, 10);
                    changeCounts.computeIfPresent(5, (k, v) -> v-1);
                }
            } else {
                if (noChange(changeCounts, 5) || noChange(changeCounts, 10)) {
                    return false;
                } else {
                    updateMap(changeCounts, 20);
                    changeCounts.computeIfPresent(5, (k, v) -> v-1);
                    changeCounts.computeIfPresent(10, (k, v) -> v-1);
                }
            }
        }
        return true;
    }

    private void updateMap(Map<Integer, Integer> changeCounts, int v) {
        int n = changeCounts.getOrDefault(v, 0);
        changeCounts.put(v, n+1);
    }

    private boolean noChange(Map<Integer, Integer> changeCounts, int v) {
        return !changeCounts.containsKey(v) || changeCounts.get(v) == 0;
    }

    public static void main(String[] args) {
        LemonadeChange lc = new LemonadeChange();
        int[] bills = {5,5,10,20,5,5,5,5,5,5,5,5,5,10,5,5,20,5,20,5};
        boolean b = lc.lemonadeChange(bills);
        System.out.println(b);
    }
}
