package algorithms;

import archive.domain.TreeNode;

public class MergeTwoBinaryTrees {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }

        if (t1 == null) {
            return t2;
        } else if (t2 == null) {
            return t2;
        } else {
            int v1 = (t1 == null) ? 0 : t1.val;
            int v2 = (t2 == null) ? 0 : t2.val;
            TreeNode root = new TreeNode(v1 + v2);
            root.left = mergeTrees(t1.left, t2.left);
            root.right = mergeTrees(t1.right, t2.right);
            return root;
        }
    }

}
