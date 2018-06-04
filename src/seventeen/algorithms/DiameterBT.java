package seventeen.algorithms;

import seventeen.domain.TreeNode;

public class DiameterBT {

    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 0;
        }

        getMax(root);
        return max;
    }

    private int getMax(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int lLen = getMax(root.left);
        int rLen = getMax(root.right);

        this.max = Math.max(max, lLen + rLen);

        return Math.max(lLen, rLen) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.makeTree();

        DiameterBT dbt = new DiameterBT();
        int diam = dbt.diameterOfBinaryTree(root);

        TreeNode.print(root);
        System.out.println(diam);
    }

}
