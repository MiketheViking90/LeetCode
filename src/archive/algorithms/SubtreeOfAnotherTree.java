package archive.algorithms;

import archive.domain.TreeNode;

public class SubtreeOfAnotherTree {

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }

        if (s == null ^ t == null) {
            return false;
        }

        if (isLeaf(s) ^ isLeaf(t)) {
            return false;
        }

        if (s.val == t.val) {
            boolean isLeft = isSubtree(s.left, t.left);
            boolean isRight = isSubtree(s.right, t.right);

            return isLeft && isRight;
        } else {
            boolean isLeft = isSubtree(s.left, t);
            boolean isRight = isSubtree(s.right, t);

            return isLeft || isRight;
        }

    }

    private boolean isLeaf(TreeNode s) {
        return s.left == null && s.right == null;
    }

}
