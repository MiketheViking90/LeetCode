package algorithms;

import archive.domain.TreeNode;

public class CousinsInBinaryTree {
    TreeNode parent = null;
    int depth = 0;

    public boolean isCousins(TreeNode root, int x, int y) {
        return findCousins(null, 0, root, x, y);
    }

    private boolean findCousins(TreeNode p, int d, TreeNode root, int x, int y) {
        if (root == null) {
            return false;
        }

        int val = root.val;
        if (val == x || val == y) {
            if (parent == null) {
                parent = p;
                depth = d;
                return false;
            } else {
                if (p != parent && d == depth) {
                    return true;
                }
            }
        }
        return findCousins(root, d+1, root.left, x, y) || findCousins(root, d+1, root.right, x, y);
    }
}
