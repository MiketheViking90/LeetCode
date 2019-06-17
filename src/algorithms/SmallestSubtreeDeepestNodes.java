package algorithms;

import archive.domain.TreeNode;

public class SmallestSubtreeDeepestNodes {
    TreeNode subTree = null;
    int d = 0;

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root;
        }

        findDepthSubtree(root, 0);
        return subTree;
    }

    private int findDepthSubtree(TreeNode root, int i) {
        if (root == null) {
            return i-1;
        }
        if (root.left == null && root.right == null) {
            if (i > d) {
                subTree = root;
                d = i;
            }
            return i;
        }

        int lDepth = findDepthSubtree(root.left, i+1);
        int rDepth = findDepthSubtree(root.right, i+1);

        if (lDepth == rDepth) {
            if (lDepth > d) {
                subTree = root;
                d = lDepth;
                return i;
            }
        }
        return Math.max(lDepth, rDepth);
    }
}
