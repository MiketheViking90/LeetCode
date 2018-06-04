package seventeen.algorithms;

import seventeen.domain.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MaxWidthBinaryTree {

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int maxWidth = 1;

        Queue<TreeNode> toVisit = new LinkedList<>();
        Queue<Integer> indicies = new LinkedList<>();
        toVisit.offer(root);
        indicies.offer(0);

        while (!toVisit.isEmpty()) {
            int size = toVisit.size();
            int left = 0;
            int right = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = toVisit.poll();
                int index = indicies.poll();
                if (index == 0) left = index;
                if (index == size-1) right = index;

                if (node.left != null) {
                    toVisit.offer(node.left);
                    indicies.offer(2*index);
                }
                if (node.right!= null) {
                    toVisit.offer(node.right);
                    indicies.offer(2*index + 1);
                }
            }
            maxWidth = Math.max(maxWidth, right - left + 1);
        }
        return maxWidth;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.makeTree();
        MaxWidthBinaryTree mwbt = new MaxWidthBinaryTree();
        int w = mwbt.widthOfBinaryTree(root);
        System.out.println(w);
    }

}
