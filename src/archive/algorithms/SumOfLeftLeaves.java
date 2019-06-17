package archive.algorithms;

import archive.domain.TreeNode;

public class SumOfLeftLeaves {

    public int sumOfLeftLeaves(TreeNode root) {
        return sumOfLeftLeaves(root, false);
    }

    private int sumOfLeftLeaves(TreeNode root, boolean isLeft) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null && isLeft) {
            return root.val;
        }

        int lSum = sumOfLeftLeaves(root.left, true);
        int rSum = sumOfLeftLeaves(root.right, false);

        return lSum + rSum;
    }

}
