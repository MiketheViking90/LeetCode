package algorithms;

import archive.domain.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevelsInBinaryTree {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> means = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int width = q.size();
            double lvlSum = 0;
            double lvlCnt = 0;

            for (int i = 0; i < width; i++) {
                TreeNode visit = q.poll();
                if (visit.left != null) q.offer(visit.left);
                if (visit.right != null) q.offer(visit.right);

                lvlSum += visit.val;
                lvlCnt++;
            }
            double mean = lvlSum/lvlCnt;
            means.add(mean);
        }
        return means;
    }
}
