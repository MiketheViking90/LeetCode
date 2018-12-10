package eighteen.algo;

import seventeen.domain.TreeNode;

public class RangeSumOfBST {

    int sum = 0;

    public int rangeSumBST(TreeNode root, int L, int R) {
        getRangeSum(root, L, R);
        return sum;
    }

    private void getRangeSum(TreeNode root, int l, int r) {
        if (root == null) {
            return;
        }
        int value = root.val;
        if (value >= l && value <= r) {
            sum += value;
        }

        if (root.left != null) {
            getRangeSum(root.left, l, r);
        }
        if (root.right != null) {
            getRangeSum(root.right, l, r);
        }
    }

    public static void main(String[] args) {
        TreeNode node = TreeNode.makeTree();
        RangeSumOfBST rs = new RangeSumOfBST();
        int sum = rs.rangeSumBST(node, 2, 4);
        System.out.println(sum);
    }
}
