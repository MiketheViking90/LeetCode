package seventeen.algorithms;

import seventeen.domain.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BTLevelTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return null;
        }

        Map<Integer, List<Integer>> numbersPerRow = new HashMap<>();
        levelOrderRecur(0, numbersPerRow, root);
        return flatten(numbersPerRow);
    }

    private void levelOrderRecur(int row, Map<Integer, List<Integer>> numbersPerRow, TreeNode root) {
        List<Integer> rowNums = numbersPerRow.getOrDefault(row, new ArrayList<>());
        System.out.println(row);
        rowNums.add(root.val);

        if (root.left != null) {
            System.out.println(root.left);
            levelOrderRecur(row + 1, numbersPerRow, root.left);
        }
        if (root.right != null) {
            System.out.println(root.right);
            levelOrderRecur(row + 1, numbersPerRow, root.right);
        }
    }


    private List<List<Integer>> flatten(Map<Integer, List<Integer>> numbersPerRow) {
        List<List<Integer>> vals = new ArrayList<>();
        for (int key : numbersPerRow.keySet()) {
            vals.add(numbersPerRow.get(key));
        }
        return vals;
    }

    public static void main(String[] args) {
        BTLevelTraversal lt = new BTLevelTraversal();

        TreeNode root = TreeNode.makeTree();
        List<List<Integer>> trav = lt.levelOrder(root);
    }
}
