package seventeen.algorithms;

import seventeen.domain.TreeNode;

public class KthSmallestInBST {

    public int kthSmallest(TreeNode root, int k) {
        int leftCnt = count(root.left);

        if (leftCnt <= k) {
            return kthSmallest(root.left, k);
        } else if (leftCnt == k + 1) {
            return root.val;
        } else {
            return kthSmallest(root.right, k - leftCnt - 1);
        }
    }

    private int count(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return (1 + count(root.left) + count(root.right));
    }

}
