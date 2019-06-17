package archive.algorithms;

import archive.domain.TreeNode;

public class PathSum {

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        return hasPathSum_R(root, 0, sum);
    }

    private boolean hasPathSum_R(TreeNode root, int curSum, int target) {
        if (root == null) {
            return false;
        }

        int newSum = curSum + root.val;
        if (root.left == null && root.right == null) {
            return newSum == target;
        }

        return hasPathSum_R(root.left, newSum, target) ||
                hasPathSum_R(root.right, newSum, target);
    }

    public static void main(String[] args) {
        //TreeNode root = TreeNode.makeTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);

        PathSum ps = new PathSum();
        boolean hasSum = ps.hasPathSum(root, 1);
        System.out.println(hasSum);
    }

}
