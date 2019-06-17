package algorithms;

import seventeen.domain.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BinaryTreeLevelTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Map<Integer, List<Integer>> levels = new HashMap<>();
        fillLevels(root, 0, levels);
        return new ArrayList<>(levels.values());
    }

    private void fillLevels(TreeNode root, int depth, Map<Integer, List<Integer>> levels) {
        if (root == null) {
            return;
        }

        List<Integer> curLevel = levels.getOrDefault(depth, new ArrayList<>());
        curLevel.add(root.val);
        levels.put(depth, curLevel);

        fillLevels(root.left, depth+1, levels);
        fillLevels(root.right, depth+1, levels);
    }
}
