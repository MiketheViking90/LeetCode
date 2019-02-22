package eighteen.algo;

import seventeen.domain.TreeNode;

public class ConvertSortedArraytoBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int m = nums.length/2;
        return buildTree(0, nums.length-1, nums);
    }

    private TreeNode buildTree(int l, int r, int[] nums) {
        if (l > r) {
            return null;
        }

        int m = (r+l)/2;
        int v = nums[m];
        TreeNode root = new TreeNode(v);
        root.left = buildTree(l, m-1, nums);
        root.right= buildTree(m+1, r, nums);
        return root;
    }

    public static void main(String[] args) {
        int[] nums = {-10,-3,0,5,9};
        ConvertSortedArraytoBinarySearchTree csa = new ConvertSortedArraytoBinarySearchTree();
        TreeNode r = csa.sortedArrayToBST(nums);
        TreeNode.print(r);
    }
}
