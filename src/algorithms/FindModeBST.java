package algorithms;

import domain.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindModeBST {

    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> valueToCounts = new HashMap<>();
        findMode(root, valueToCounts);

        int maxCount = -1;
        for (int count : valueToCounts.values()) {
            if (count > maxCount) {
                maxCount = count;
            }
        }

        List<Integer> modes = new ArrayList<>();
        for (int value : valueToCounts.keySet()) {
            int count = valueToCounts.get(value);
            if (count == maxCount) {
                modes.add(value);
            }
        }
        int len = modes.size();
        int[] rv = new int[len];

        for (int i=0; i<len; i++) {
            rv[i] = modes.get(i);
        }
        return rv;
    }

    private void findMode(TreeNode root, Map<Integer, Integer> valueToCounts) {
        if (root == null) {
            return;
        }
        int rootVal = root.val;
        int count = valueToCounts.getOrDefault(rootVal, 0);
        valueToCounts.put(rootVal, count + 1);

        findMode(root.left, valueToCounts);
        findMode(root.right, valueToCounts);
    }

}
