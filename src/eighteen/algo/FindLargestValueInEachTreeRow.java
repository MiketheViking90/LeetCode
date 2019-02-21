package eighteen.algo;

import seventeen.domain.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindLargestValueInEachTreeRow {
    public List<Integer> largestValues(TreeNode root) {
        Map<Integer, Integer> rowMax = new HashMap<>();
        rowTrav(root, 0, rowMax);

        List<Integer> maxs = new ArrayList<>();
        int row = 0;
        while (rowMax.containsKey(row++)) {
            int max = rowMax.get(row);
            maxs.add(max);
        }
        return maxs;
    }

    private void rowTrav(TreeNode root, int row, Map<Integer, Integer> rowMax) {
        if (root == null) {
            return;
        }

        int val = root.val;
        if (!rowMax.containsKey(row)) {
            rowMax.put(row, val);
        } else {
            int cur = rowMax.get(cur);
            rowMax.put(row, Math.max())
        }
    }
}
