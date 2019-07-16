package algorithms;

import archive.domain.TreeNode;

public class SerAndDeserBinaryTree {

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        traverseTree(sb, root);
        return sb.toString();
    }

    private void traverseTree(StringBuilder sb, TreeNode root) {
        if (root == null) {
            sb.append(", ");
            return;
        }

        if (root.left == null && root.right == null) {
            sb.append(root.val + ", ");
            return;
        }

        traverseTree(sb, root.left);
        traverseTree(sb, root.right);
        sb.append(root.val + ", ");
    }

    public TreeNode deserialize(String data) {
        return null;
    }

    public static void main(String[] args) {
        SerAndDeserBinaryTree ser = new SerAndDeserBinaryTree();
        String serial = ser.serialize(TreeNode.makeTree());
        System.out.println(serial);
    }
}
