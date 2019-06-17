package algorithms;

import seventeen.domain.TreeNode;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left == null ^ right == null) {
            return false;
        }

        boolean valMatch = left.val == right.val;
        return valMatch && isSymmetric(left.right, right.left)
                        && isSymmetric(left.left, right.right);
    }
}
