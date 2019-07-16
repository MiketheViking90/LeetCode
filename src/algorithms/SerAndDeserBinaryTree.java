package algorithms;

import archive.domain.TreeNode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

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
        Deque<String> nodeStack = new LinkedList<>();
        List<String> dataList = Arrays.asList(data.split(", "));
        for (String s : dataList) {
            nodeStack.push(s);
        }
        return buildTree(nodeStack);
    }

    private TreeNode buildTree(Deque<String> nodeStack) {
        if (nodeStack.isEmpty()) {
            return null;
        }
        String top = nodeStack.pop();
        if (top.equals("")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(top));
        node.right = buildTree(nodeStack);
        node.left = buildTree(nodeStack);
        return node;
    }

    public static void main(String[] args) {
        SerAndDeserBinaryTree ser = new SerAndDeserBinaryTree();
        String serial = ser.serialize(TreeNode.makeTree());
        //System.out.println(serial);

        TreeNode node = ser.deserialize(serial);
        TreeNode.print(node);
        TreeNode.print(TreeNode.makeTree());
    }
}
