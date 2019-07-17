package algorithms;

import archive.domain.TreeNode;

public class KthSmallestElementBST {
    TreeNode kth = null;

    public int kthSmallest(TreeNode root, int k) {
        countTree(root, k);
        return kth.val;
    }

    private int countTree(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }

        int lCount = countTree(root.left, k);
        if (lCount == k - 1) {
            kth = root;
        }

        int rCount = countTree(root.right, k - lCount - 1);
        return lCount + rCount + 1;
    }
}
