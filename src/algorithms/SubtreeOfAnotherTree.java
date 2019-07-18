package algorithms;

import archive.domain.TreeNode;

public class SubtreeOfAnotherTree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null ^ t != null) {
            return false;
        }

        if (s.val == t.val) {
            return isSubtree(s.left, t.left) && isSubtree(s.right, t.right);
        }
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }
}
