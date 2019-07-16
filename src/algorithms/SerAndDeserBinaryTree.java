package algorithms;

import archive.domain.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerAndDeserBinaryTree {
    private static final String DELIM = ",";
    private static final String NAN = "X";

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(sb, root);
        return sb.toString();
    }

    private void buildString(StringBuilder sb, TreeNode root) {
        if (root == null) {
            sb.append(NAN + DELIM);
            return;
        }
        sb.append(root.val + DELIM);
        buildString(sb, root.left);
        buildString(sb, root.right);
    }

    public TreeNode deserialize(String ser) {
        String[] tokens = ser.split(DELIM);
        Queue<String> tokensList = new LinkedList<>(Arrays.asList(tokens));
        return buildTree(tokensList);
    }

    private TreeNode buildTree(Queue<String> tokensList) {
        String token = tokensList.poll();
        if (token.equals(NAN)) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(token));
        node.left = buildTree(tokensList);
        node.right = buildTree(tokensList);
        return node;
    }

    public static void main(String[] args) {
        SerAndDeserBinaryTree ser = new SerAndDeserBinaryTree();
        String serial = ser.serialize(TreeNode.makeTree());
        System.out.println(serial);

        TreeNode node = ser.deserialize(serial);
        TreeNode.print(node);
    }
}
