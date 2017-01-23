package algorithms;

import domain.TreeNode;

public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null ^ q == null) {
            return false;
        }

        boolean isSameValue = p.val == q.val;
        boolean isLeftSame = isSameTree(p.left, q.left);
        boolean isRightSame = isSameTree(p.right, q.right);

        return isSameValue && isLeftSame && isRightSame;
    }

    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        TreeNode q = new TreeNode(2);

        SameTree st = new SameTree();
        boolean isSame = st.isSameTree(null, q);
        System.out.println(isSame);
    }

}
