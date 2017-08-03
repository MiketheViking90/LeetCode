package algorithms;

import domain.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class AddOneRowToTree {

    public TreeNode addOneRow(TreeNode root, int v, int d) {
        Queue<TreeNode> visitQ = new LinkedList<>();
        visitQ.add(root);
        int depth = 0;

        while (depth <= d) {
            int depthPop = visitQ.size();

            for (int i = 0; i < depthPop; i++) {
                TreeNode visit = visitQ.poll();

                if (visit.left != null) {
                    visitQ.add(visit.left);
                }

                if (visit.right != null) {
                    visitQ.add(visit.right);
                }
            }
            depth++;
        }

        System.out.println(Arrays.toString(visitQ.toArray()));

        for (TreeNode node : visitQ) {
            TreeNode curL = node.left;
            TreeNode curR = node.right;

            TreeNode newL = new TreeNode(v);
            TreeNode newR = new TreeNode(v);

            newL.left = curL;
            newR.right = curR;

            node.left = newL;
            node.right = newR;
        }

        return root;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.makeTree();
        TreeNode.print(root);

        AddOneRowToTree aortt = new AddOneRowToTree();
        TreeNode newRoot = aortt.addOneRow(root, 33, 2);
        TreeNode.print(newRoot);
    }

}
