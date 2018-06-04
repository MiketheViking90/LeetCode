package seventeen.algorithms;

import seventeen.domain.TreeNode;

public class ConstructStringFromBinaryTree {

    String constructString(TreeNode node) {
        StringBuffer treeAsString = new StringBuffer();
        constructString(node, treeAsString);
        
        return treeAsString.toString();
    }

    private void constructString(TreeNode node, StringBuffer treeAsString) {
        if (node == null) {
            return;
        }

        treeAsString.append(node.val);

        if (node.isLeaf()) {
            return;
        }

        treeAsString.append("(");
        constructString(node.left, treeAsString);

        treeAsString.append(")");
        constructString(node.right, treeAsString);
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.makeTree();

        ConstructStringFromBinaryTree csbt = new ConstructStringFromBinaryTree();
        String treeStr = csbt.constructString(root);
        System.out.println(treeStr);
    }
}
