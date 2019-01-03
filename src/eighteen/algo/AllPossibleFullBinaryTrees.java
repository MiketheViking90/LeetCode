package eighteen.algo;

import seventeen.domain.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllPossibleFullBinaryTrees {

    Map<Integer, List<TreeNode>> map = new HashMap<>();

    public List<TreeNode> allPossibleFBT(int N) {
        if (N % 2 == 0) {
            return new ArrayList<>();
        }

        if (map.containsKey(N)) {
            return map.get(N);
        }

        List<TreeNode> trees = new ArrayList<>();
        if (N == 1) {
            trees.add(new TreeNode(0));
            return trees;
        }

        for (int x = 1; x < N; x+=2) {
            int y = N - x- 1;

            List<TreeNode> leftTrees = allPossibleFBT(x);
            List<TreeNode> rightTrees = allPossibleFBT(y);

            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode root = new TreeNode(0);
                    root.left = left;
                    root.right = right;

                    trees.add(root);
                }
            }
        }
        map.put(N, trees);
        return map.get(N);
    }

}
