package seventeen.algorithms;

import seventeen.domain.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightViewBST {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> view = new ArrayList<>();
        Queue<TreeNode> bsfVisit = new LinkedList<>();
        bsfVisit.add(root);

        while (bsfVisit.size() != 0) {

            int levelSize = bsfVisit.size();
            for (int i=0; i<levelSize; i++) {
                TreeNode curNode = bsfVisit.poll();
                if (i== 0) {
                    view.add(curNode.val);
                }

                if (curNode.right != null) {
                    bsfVisit.add(curNode.right);
                }
                if (curNode.left != null) {
                    bsfVisit.add(curNode.left);
                }
            }
        }
        return view;
    }

}
