package eighteen.algo;

import seventeen.domain.TreeNode;

public class BinaryTreePruning {

    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);

        if (root.left == null && root.right == null) {
            if (root.val == 0) {
                return null;
            } else {
                return root;
            }
        }
        return root;
    }

}
