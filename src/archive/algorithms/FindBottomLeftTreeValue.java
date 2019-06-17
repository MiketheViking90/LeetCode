package archive.algorithms;

import archive.domain.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class FindBottomLeftTreeValue {

    int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> visitQ = new LinkedList<>();
        visitQ.add(root);
        int btmLeft = root.val;

        while (!visitQ.isEmpty()) {
            int depthCnt = visitQ.size();
            btmLeft = visitQ.peek().val;
            for (int i = 0; i < depthCnt; i++) {
                TreeNode visit = visitQ.poll();

                if (visit.left != null) {
                    visitQ.offer(visit.left);
                }
                if (visit.right!= null) {
                    visitQ.offer(visit.right);
                }
            }
        }

        return btmLeft;
    }
}
