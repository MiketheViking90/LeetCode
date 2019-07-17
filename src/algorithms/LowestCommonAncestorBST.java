package algorithms;

import archive.domain.TreeNode;

public class LowestCommonAncestorBST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        int pVal = p.val;
        int qVal = q.val;
        int rVal = root.val;

        if (pVal > rVal && qVal > rVal) {
            return lowestCommonAncestor(root.right, p, q);
        } else if (pVal < rVal && qVal < rVal) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return root;
        }
    }
}
