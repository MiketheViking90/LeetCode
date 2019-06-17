package archive.algorithms;

import archive.domain.TreeNode;

public class MinimumAbsoluteDifferenceInBST {

    public int getMinimumDifference(TreeNode root) {
        return Math.min(
                getMinDiffTraversal(root.left, root.val),
                getMinDiffTraversal(root.right, root.val)
        );
    }

    private int getMinDiffTraversal(TreeNode root, Integer prev) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }

        int lDiff = getMinDiffTraversal(root.left, Math.min(root.val, prev));
        int curDiff = Math.abs(root.val - prev);
        int rDiff = getMinDiffTraversal(root.left, Math.max(root.val, prev));

        return Math.min(Math.min(lDiff, curDiff), rDiff);
    }

}
