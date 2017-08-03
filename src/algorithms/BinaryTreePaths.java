package algorithms;

import domain.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        getPaths(root, "", paths);
        return paths;
    }

    private void getPaths(TreeNode root, String curPath, List<String> paths) {
        if (root == null) {
            return;
        }

        if (curPath.equals("")) {
            curPath += root.val;
        } else {
            curPath += ("->" + root.val);
        }

        if (root.left == null && root.right == null) {
            paths.add(curPath);
            return;
        }

        getPaths(root.left, curPath, paths);
        getPaths(root.right, curPath, paths);
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.makeTree();

        BinaryTreePaths btp = new BinaryTreePaths();
        List<String> paths = btp.binaryTreePaths(root);
        System.out.println(Arrays.toString(paths.toArray()));
    }

}
