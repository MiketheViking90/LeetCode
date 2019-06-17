package algorithms;

import archive.domain.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {

    List<Integer> trav = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        iot(root);
        return trav;
    }

    private void iot(TreeNode root) {
        if (root == null) {
            return;
        }

        iot(root.left);
        trav.add(root.val);
        iot(root.right);
    }

}
