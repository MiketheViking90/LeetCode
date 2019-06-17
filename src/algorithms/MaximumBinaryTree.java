package algorithms;

import seventeen.algorithms.MaxBinaryTree;
import seventeen.domain.TreeNode;

public class MaximumBinaryTree {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructTreeR(nums, 0, nums.length-1);
    }

    private TreeNode constructTreeR(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }

        int maxIndex = getMaxIndex(nums, l, r);
        int max = nums[maxIndex];

        TreeNode root = new TreeNode(max);
        root.left = constructTreeR(nums, l, maxIndex-1);
        root.right = constructTreeR(nums, maxIndex+1, r);
        return root;
    }

    private int getMaxIndex(int[] nums, int l, int  r) {
        int max = nums[l];
        int maxI = l;

        for (int i = l+1; i <= r; i++) {
           if (nums[i] > max) {
               max = nums[i];
               maxI = i;
           }
        }

        return maxI;
    }

    public static void main(String[] args) {
        TreeNode tree = TreeNode.makeTree();
        int[] nums = {3,2,1,6,0,5};

        MaxBinaryTree mbt = new MaxBinaryTree();
        TreeNode tree1 = mbt.constructMaximumBinaryTree(nums);

        TreeNode.print(tree1);
    }

}
