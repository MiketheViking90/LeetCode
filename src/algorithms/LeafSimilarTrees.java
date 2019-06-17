package algorithms;

import seventeen.domain.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LeafSimilarTrees {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {

        List<Integer> leafPath1 = new ArrayList<>();
        List<Integer> leafPath2 = new ArrayList<>();

        findLeaves(root1, leafPath1);
        findLeaves(root2, leafPath2);

        if (leafPath1.size() != leafPath2.size()) {
            return false;
        }

        for (int i = 0; i < leafPath1.size(); i++) {
            int a = leafPath1.get(i);
            int b = leafPath2.get(i);

            if (a != b) {
                return false;
            }
        }
        return true;
    }

    private void findLeaves(TreeNode root, List<Integer> leafPath) {
        if (root == null) {
            return;
        }

        findLeaves(root.left, leafPath);
        if (root.left == null && root.right == null) {
            leafPath.add(root.val);
        }
        findLeaves(root.right, leafPath);
    }
}
