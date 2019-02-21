package eighteen.algo;

import seventeen.domain.TreeNode;

public class FindBottomLeftTreeValue {
    int btmRow = 0;
    int btmVal = 0;

    public int findBottomLeftValue(TreeNode root) {
        findBlValue(root, 0);
        return btmVal;
    }

    private void findBlValue(TreeNode root, int row) {
        if (root == null) {
            return;
        }

        if (row > btmRow) {
            btmRow = row;
            btmVal = root.val;
        }

        findBlValue(root.left, row+1);
        findBlValue(root.right, row+1);
    }
}
