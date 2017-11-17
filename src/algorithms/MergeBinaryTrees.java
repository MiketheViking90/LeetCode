package algorithms;

import domain.TreeNode;

public class MergeBinaryTrees {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        return merge(t1, t2);
    }

    private TreeNode merge(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }

        TreeNode root;
        if (t1 == null) {
            root = t2;
        } else if (t2 == null) {
            root = t1;
        } else {
            root = new TreeNode(t1.val + t2.val);
            root.right = merge(t1.right, t2.right);
            root.left = merge(t1.left, t2.left);
        }

        return root;
    }

}
