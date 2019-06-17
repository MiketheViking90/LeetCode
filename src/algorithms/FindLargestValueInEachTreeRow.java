package algorithms;

import seventeen.domain.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class FindLargestValueInEachTreeRow {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> rowMax = new ArrayList<>();
        rowTrav(root, 0, rowMax);
        return rowMax;
    }

    private void rowTrav(TreeNode root, int row, List<Integer> rowMax) {
        if (root == null) {
            return;
        }

        int val = root.val;
        if (rowMax.size() <= row) {
            rowMax.add(val);
        } else {
            int curMax = Math.max(val, rowMax.get(row));
            rowMax.set(row, curMax);
        }

        rowTrav(root.left, row+1, rowMax);
        rowTrav(root.right, row+1, rowMax);
    }

    public static void main(String[] args) {
        System.out.println("hello");
        FindLargestValueInEachTreeRow fl = new FindLargestValueInEachTreeRow();
        List<Integer> max = fl.largestValues(TreeNode.makeTree());
        System.out.println(max);
        System.out.println("done");

        System.out.println("google.com/images/Lyft".hashCode());
        System.out.println("google.com/images/Airbnb".hashCode());
    }
}
