package algorithms;

import domain.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class KthSmallestElementBST {

    public int kthSmallest(TreeNode root, int k) {
        TreeNode node = root;
        Deque<TreeNode> leftNodes = new LinkedList<>();

        while (!leftNodes.isEmpty() && node != null) {
            if (node != null) {
                leftNodes.push(node);
                node = node.left;
            } else {
                node = leftNodes.pop();
                k--;

                if (k == 0) {
                    return node.val;
                }
                node = node.right;
            }
        }

        return -1;
    }
}
