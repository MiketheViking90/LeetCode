package algorithms;

import archive.domain.TreeNode;

public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return isBSTValidator(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isBSTValidator(TreeNode root, long minValue, long maxValue) {
        if (root == null) {
            return true;
        }

        int val = root.val;
        if (val >= maxValue || val <= minValue) {
            return false;
        }

        boolean lBST = isBSTValidator(root.left, minValue, val);
        boolean rBST = isBSTValidator(root.right, val, maxValue);
        return lBST && rBST;
    }
}
