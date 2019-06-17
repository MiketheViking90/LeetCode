package archive.algorithms;

import archive.domain.TreeNode;

public class ValidateBST {

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isValidBST(root.left, Long.MIN_VALUE, root.val) &&
                isValidBST(root.right, root.val, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long minValue, long maxValue) {
        if (root == null) {
            return true;
        }

        int rootVal = root.val;
        if (minValue >= rootVal || maxValue <= rootVal) {
            return false;
        }

        boolean isLeftValid = isValidBST(root.left, minValue, rootVal);
        boolean isRightValid = isValidBST(root.right, rootVal, maxValue);
        return isLeftValid && isRightValid;
    }

}
