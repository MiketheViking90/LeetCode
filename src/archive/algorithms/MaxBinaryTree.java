package archive.algorithms;

import archive.domain.TreeNode;

public class MaxBinaryTree {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int n = nums.length;
        return getTree(nums, 0, n);
    }

    private TreeNode getTree(int[] nums, int start, int end) {
        if (start >= end) {
            return null;
        }

        if (start == (end - 1)) {
            return new TreeNode(nums[start]);
        }

        int max = nums[start];
        int maxIdx = start;
        for (int i = start; i < end; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIdx = i;
            }
        }

        TreeNode root = new TreeNode(max);
        root.left = getTree(nums, start, maxIdx);
        root.right = getTree(nums, maxIdx + 1, end);
        return root;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,6,0,5};
        MaxBinaryTree mbt = new MaxBinaryTree();
        TreeNode root = mbt.constructMaximumBinaryTree(nums);
        TreeNode.print(root);
    }

}
