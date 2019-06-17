package archive.algorithms;

import archive.domain.TreeNode;

public class BinaryTreeMaxPathSum {

    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxPathSumR(root);
        return maxSum;
    }

    private int maxPathSumR(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int lSum = maxPathSumR(root.left);
        int rSum = maxPathSumR(root.right);

        int pathSum = lSum + rSum + root.val;
        maxSum = Math.max(maxSum, pathSum);
        maxSum = Math.max(maxSum, root.val);
        maxSum = Math.max(maxSum, root.val + lSum);
        maxSum = Math.max(maxSum, root.val + rSum);

        return Math.max(lSum, rSum) + root.val;
    }

}
