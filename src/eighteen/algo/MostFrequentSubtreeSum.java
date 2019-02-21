package eighteen.algo;

import seventeen.domain.TreeNode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MostFrequentSubtreeSum {
    Map<Integer, Integer> sumToCounts = new HashMap<>();

    public int[] findFrequentTreeSum(TreeNode root) {
        getSums(root);
        int n = getMax(sumToCounts.values());
        List<Integer> res = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : sumToCounts.entrySet()) {
            int k = entry.getKey();
            int v = entry.getValue();

            if (v == n) {
                res.add(k);
            }
        }
        int[] ary = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ary[i] = res.get(i);
        }
        return ary;
    }

    private int getMax(Collection<Integer> counts) {
        int max = 0;
        for (int n : counts) {
            max = Math.max(max, n);
        }
        return max;
    }

    private int getSums(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int val = root.val;
        int lSum = getSums(root.left);
        int rSum = getSums(root.right);
        int sum = val + lSum + rSum;
        int n = sumToCounts.getOrDefault(sum, 0);
        sumToCounts.put(sum, n+1);
        return sum;
    }
}
