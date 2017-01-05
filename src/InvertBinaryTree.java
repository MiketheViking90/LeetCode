import domain.TreeNode;

public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        if (root.left == null && root.right == null) {
            return root;
        }

        invertTree(root.right);
        invertTree(root.left);

        TreeNode lNode = root.left;
        root.left = root.right;
        root.right = lNode;
        return root;
    }

}
