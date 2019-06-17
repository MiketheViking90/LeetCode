package algorithms;

import archive.domain.TreeNode;

public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }

        invertTree(root.left);
        invertTree(root.right);

        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;

        return root;
    }
}
