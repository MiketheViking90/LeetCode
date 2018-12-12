package eighteen.algo;

import seventeen.domain.TreeNode;

public class InsertIntoABST {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root.val > val && root.left == null) {
            root.left = new TreeNode(val);
            return root;
        } else if (root.val < val && root.right == null) {
            root.right = new TreeNode(val);
            return root;
        } else if (root.val > val) {
            insertIntoBST(root.left, val);
        } else {
            insertIntoBST(root.right, val);
        }

        return root;
    }

    public static void main(String[] args) {
        TreeNode node = TreeNode.makeTree();
        InsertIntoABST ii = new InsertIntoABST();

        TreeNode newNode = ii.insertIntoBST(node, 100);
        TreeNode.print(newNode);
    }

}
