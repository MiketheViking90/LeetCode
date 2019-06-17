package archive.algorithms;

import archive.domain.TreeNode;

public class BinarySearchTree {

    public static TreeNode lca(TreeNode root, int val1, int val2) {
        if (root == null) {
            return root;
        }

        int rootVal = root.val;
        if (rootVal == val1 || rootVal == val2) {
            return root;
        }

        if (val1 < rootVal && val2 > rootVal ||
                val1 > rootVal && val2 < rootVal) {
            return root;
        } else if (val1 < rootVal && val2 < rootVal) {
            return lca(root.left, val1, val2);
        } else {
            return lca(root.right, val2, val2);
        }
    }
}
