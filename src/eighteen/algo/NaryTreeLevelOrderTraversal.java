package eighteen.algo;

import seventeen.domain.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<Node> toVisit = new LinkedList<>();

        toVisit.offer(root);
        while(!toVisit.isEmpty()) {
            int breadth = toVisit.size();
            List<Integer> lvl = new ArrayList<>();

            while (breadth > 0) {
                Node visit = toVisit.poll();
                lvl.add(visit.val);
                toVisit.addAll(visit.children);
                breadth--;
            }
            res.add(lvl);
        }
        return res;
    }

    public static void main(String[] args) {
        NaryTreeLevelOrderTraversal nt = new NaryTreeLevelOrderTraversal();
        Node node = Node.makeNode();
        System.out.println(nt.levelOrder(node));
    }
}
