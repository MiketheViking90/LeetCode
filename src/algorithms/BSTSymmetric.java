package algorithms;

import domain.TreeNode;

public class BSTSymmetric {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return compareNodes(root.left, root.right);
    }

    private boolean compareNodes(TreeNode node1, TreeNode node2) {
        if ((node1 != null && node2 == null )||
                (node1 == null && node2 != null)) {
            return false;
        }

        boolean sameValues = (node1.val == node2.val);
        boolean outerCompare = compareNodes(node1.left, node2.right);
        boolean innerCompare = compareNodes(node1.right, node2.left);
        return sameValues && outerCompare && innerCompare;
    }

}
