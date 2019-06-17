package archive.algorithms;

import archive.domain.TreeNode;

public class ConvertBSTtoGreaterTree {

    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        convert(root);
        return root;
    }

    private void convert(TreeNode root) {
        if (root == null) {
            return;
        }

        convert(root.right);
        int val = root.val;
        root.val += sum;
        sum += val;
        convert(root.left);
    }


    public static void main(String[] args) {
        TreeNode root = TreeNode.makeTree();

        ConvertBSTtoGreaterTree cbst = new ConvertBSTtoGreaterTree();
        TreeNode groot = cbst.convertBST(root);

        TreeNode.print(groot);
    }
}
