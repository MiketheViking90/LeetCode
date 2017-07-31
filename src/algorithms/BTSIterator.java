package algorithms;

import domain.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class BTSIterator {

    private Deque<TreeNode> values = new LinkedList<>();

    public BTSIterator(TreeNode node) {
        pushLeft(node);
    }

    public boolean hasNext() {
        return !values.isEmpty();
    }

    public int next() {
        TreeNode curNode = values.pop();
        pushLeft(curNode.right);
        return curNode.val;
    }

    private void pushLeft(TreeNode node) {
        while (node != null) {
            values.push(node);
            node = node.left;
        }
    }

}
