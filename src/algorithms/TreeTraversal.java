package algorithms;

import domain.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class TreeTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> traversal = new ArrayList<>();
        return inorderTraversal(root, traversal);
    }

    private List<Integer> inorderTraversal(TreeNode root, List<Integer> traversal) {
        if (root == null) {
            return traversal;
        }

        inorderTraversal(root.left, traversal);
        traversal.add(root.val);
        inorderTraversal(root.right, traversal);

        return traversal;
    }


    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> traversal = new ArrayList<>();
        return preorderTraversal(root, traversal);
    }

    private List<Integer> preorderTraversal(TreeNode root, List<Integer> traversal) {
        if (root == null) {
            return traversal;
        }

        preorderTraversal(root.left, traversal);
        preorderTraversal(root.right, traversal);
        traversal.add(root.val);

        return traversal;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> traversal = new ArrayList<>();
        return postorderTraversal(root, traversal);
    }

    private List<Integer> postorderTraversal(TreeNode root, List<Integer> traversal) {
        if (root == null) {
            return traversal;
        }

        postorderTraversal(root.left, traversal);
        postorderTraversal(root.right, traversal);
        traversal.add(root.val);

        return traversal;
    }

}
